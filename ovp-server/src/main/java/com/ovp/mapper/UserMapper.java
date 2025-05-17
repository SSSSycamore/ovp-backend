package com.ovp.mapper;

import com.ovp.annotation.AutoFill;
import com.ovp.entity.User;
import com.ovp.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @AutoFill(value = OperationType.INSERT)
    void insert(User user);

    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);

    @Select("select * from user where id = #{userId}")
    User selectByUserId(Long userId);

    @Delete("delete from user where id = #{userId}")
    void deleteByUserId(Long userId);

    @AutoFill(value = OperationType.UPDATE)
    void updateByUserId(User updatedUser);
}
