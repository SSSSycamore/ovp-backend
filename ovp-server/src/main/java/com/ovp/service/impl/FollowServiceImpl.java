package com.ovp.service.impl;

import com.ovp.context.BaseContext;
import com.ovp.mapper.FollowMapper;
import com.ovp.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {
    private final FollowMapper followMapper;

    @Override
    public Integer getFansCountById(Long id) {
        return followMapper.getFansCountById(id);
    }

    @Override
    public Integer getFollowCountById(Long id) {
        return followMapper.getFollowCountById(id);
    }

    @Override
    public Boolean isFollowByCurrentUser(Long id) {
        Long currentId = BaseContext.getCurrentId();
        return followMapper.isFollowByCurrentUser(id,currentId) > 0;
    }
}
