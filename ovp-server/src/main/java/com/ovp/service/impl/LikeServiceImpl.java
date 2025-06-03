package com.ovp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ovp.context.BaseContext;
import com.ovp.entity.Like;
import com.ovp.mapper.LikeMapper;
import com.ovp.result.Result;
import com.ovp.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeMapper likeMapper;

    @Override
    public void likeVideo(Long videoId) {
        Long currentId = BaseContext.getCurrentId();
        Like like = Like.builder()
                .videoId(videoId)
                .userId(BaseContext.getCurrentId())
                .build();
        likeMapper.insert(like);
    }
}
