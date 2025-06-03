package com.ovp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ovp.entity.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VideoMapper extends BaseMapper<Video> {
    @Select("select count(*) from video where user_id = #{id}")
    Integer getVideoCountById(Long id);
}
