package com.ovp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ovp.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    // 这里可以添加其他与评论相关的查询方法
}
