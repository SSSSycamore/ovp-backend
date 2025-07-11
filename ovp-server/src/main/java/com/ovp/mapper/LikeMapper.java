package com.ovp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ovp.entity.Like;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper extends BaseMapper<Like> {
    void likeVideo(Long videoId);
}
