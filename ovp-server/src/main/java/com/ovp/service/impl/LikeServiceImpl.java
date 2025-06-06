package com.ovp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ovp.context.BaseContext;
import com.ovp.entity.Comment;
import com.ovp.entity.Like;
import com.ovp.entity.Video;
import com.ovp.mapper.CommentMapper;
import com.ovp.mapper.LikeMapper;
import com.ovp.mapper.VideoMapper;
import com.ovp.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeMapper likeMapper;
    private final VideoMapper videoMapper;

    @Transactional
    @Override
    public Boolean changeVideoLike(Long videoId) {
        // 检查用户是否已经点赞
        QueryWrapper<Like> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("video_id", videoId)
                .eq("user_id", BaseContext.getCurrentId());
        Like existingLike = likeMapper.selectOne(queryWrapper);
        if (existingLike != null) {
            // 如果已经点赞，返回结果
            likeMapper.delete(queryWrapper);
            videoMapper.deductLikeCount(videoId);
            return false; // 取消点赞
        } else {
            Long currentId = BaseContext.getCurrentId();
            Like like = Like.builder()
                    .videoId(videoId)
                    .createTime(LocalDateTime.now())
                    .userId(BaseContext.getCurrentId())
                    .build();
            likeMapper.insert(like);
            // 更新视频的点赞数量
            videoMapper.addLikeCount(videoId);
            return true; // 点赞成功
        }
    }

    @Override
    public Boolean changeCommentLike(Long commentId) {
        // 检查用户是否已经点赞
        QueryWrapper<Like> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("comment_id", commentId)
                .eq("user_id", BaseContext.getCurrentId());
        Like existingLike = likeMapper.selectOne(queryWrapper);
        if (existingLike != null) {
            // 如果已经点赞，返回结果
            likeMapper.delete(queryWrapper);
            return false; // 取消点赞
        } else {
            Long currentId = BaseContext.getCurrentId();
            Like like = Like.builder()
                    .commentId(commentId)
                    .createTime(LocalDateTime.now())
                    .userId(BaseContext.getCurrentId())
                    .build();
            likeMapper.insert(like);
            return true; // 点赞成功
        }
    }
}
