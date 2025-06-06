package com.ovp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ovp.context.BaseContext;
import com.ovp.entity.Comment;
import com.ovp.entity.Like;
import com.ovp.mapper.CommentMapper;
import com.ovp.mapper.LikeMapper;
import com.ovp.mapper.VideoMapper;
import com.ovp.service.CommentService;
import com.ovp.vo.CommentTreeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;
    private final LikeMapper likeMapper;
    private final VideoMapper videoMapper;
    @Override
    public List<CommentTreeVO> queryVideoComments(Long videoId) {
        List<CommentTreeVO> commentTreeVOS = commentMapper.queryVideoComments(videoId);
        Map<Long, CommentTreeVO> idMap = commentTreeVOS.stream()
                .collect(Collectors.toMap(CommentTreeVO::getId,
                        commentTreeVO -> commentTreeVO,
                        (val1, val2) -> val2));
        List<CommentTreeVO> rootComments = new ArrayList<>();
        for (CommentTreeVO comment : commentTreeVOS) {
            if (comment.getParentId() == null) {
                rootComments.add(comment);
            } else {
                CommentTreeVO parentComment = idMap.get(comment.getParentId());
                if (parentComment != null) {
                    if (parentComment.getChildrenComments() == null) {
                        parentComment.setChildrenComments(new ArrayList<>());
                    }
                    parentComment.getChildrenComments().add(comment);
                }
            }
            Long currentId = BaseContext.getCurrentId();
            comment.setIsLike(checkIfLiked(comment.getId(), currentId));
        }
        return rootComments;
    }

    @Override
    @Transactional
    public void save(Comment comment) {
        Long currentId = BaseContext.getCurrentId();
        comment.setUserId(currentId);
        comment.setCreateTime(LocalDateTime.now());
        commentMapper.insert(comment);
        // 增加视频评论数
        videoMapper.addCommentCount(comment.getVideoId());
    }

    private Boolean checkIfLiked(Long commentId, Long currentId) {
        return likeMapper.selectOne(new LambdaQueryWrapper<Like>()
                .eq(Like::getCommentId, commentId)
                .eq(Like::getUserId, currentId)) != null;
    }
}
