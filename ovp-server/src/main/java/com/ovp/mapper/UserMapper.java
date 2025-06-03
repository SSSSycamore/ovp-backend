package com.ovp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ovp.annotation.AutoFill;
import com.ovp.entity.User;
import com.ovp.enumeration.OperationType;
import com.ovp.vo.UserQueryVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @AutoFill(value = OperationType.INSERT)
    void insertUser(User user);

    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);

    @Select("select * from user where id = #{userId}")
    User selectByUserId(Long userId);

    @Delete("delete from user where id = #{userId}")
    void deleteByUserId(Long userId);

    @AutoFill(value = OperationType.UPDATE)
    void updateByUserId(User updatedUser);

    List<UserQueryVO> querySortedUserListByNickname(String nickname, String sortBy,String sortOrder);
}
