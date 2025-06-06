package com.ovp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ovp.entity.Comment;
import com.ovp.vo.CommentTreeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    List<CommentTreeVO> queryVideoComments(Long videoId);
    // 这里可以添加其他与评论相关的查询方法
}
