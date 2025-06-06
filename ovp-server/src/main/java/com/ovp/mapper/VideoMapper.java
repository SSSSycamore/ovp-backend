package com.ovp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ovp.entity.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface VideoMapper extends BaseMapper<Video> {
    @Select("select count(*) from video where user_id = #{id}")
    Integer getVideoCountById(Long id);

    @Update("update video set like_count = like_count - 1 where id = #{videoId}")
    void deductLikeCount(Long videoId);

    @Update("update video set like_count = like_count + 1 where id = #{videoId}")
    void addLikeCount(Long videoId);

    @Update("update video set comment_count = comment_count + 1 where id = #{videoId}")
    void addCommentCount(Long videoId);
}
