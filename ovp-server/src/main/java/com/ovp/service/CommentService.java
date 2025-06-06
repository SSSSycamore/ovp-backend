package com.ovp.service;

import com.ovp.entity.Comment;
import com.ovp.vo.CommentTreeVO;

import java.util.List;

public interface CommentService {
    List<CommentTreeVO> queryVideoComments(Long videoId);

    void save(Comment comment);
}
