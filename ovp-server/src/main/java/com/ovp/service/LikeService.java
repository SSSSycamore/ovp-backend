package com.ovp.service;

public interface LikeService {

    Boolean changeVideoLike(Long videoId);

    Boolean changeCommentLike(Long commentId);
}
