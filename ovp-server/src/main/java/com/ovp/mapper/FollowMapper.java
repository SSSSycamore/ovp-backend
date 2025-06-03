package com.ovp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ovp.entity.Follow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FollowMapper extends BaseMapper<Follow> {
    @Select("select count(*) from follow where followee_id = #{id}")
    Integer getFansCountById(Long id);

    @Select("select count(*) from follow where follower_id = #{id}")
    Integer getFollowCountById(Long id);

    @Select("select count(*) from follow where followee_id = #{id} and follower_id = #{currentUserId}")
    Integer isFollowByCurrentUser(Long id,Long currentUserId);
}
