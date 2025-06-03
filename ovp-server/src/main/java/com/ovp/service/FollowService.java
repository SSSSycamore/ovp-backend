package com.ovp.service;

import org.apache.ibatis.annotations.Select;

public interface FollowService {
    Integer getFansCountById(Long id);

    Integer getFollowCountById(Long id);

    Boolean isFollowByCurrentUser(Long id);
}
