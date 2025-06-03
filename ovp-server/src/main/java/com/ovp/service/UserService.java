package com.ovp.service;

import com.ovp.dto.UserLoginDTO;
import com.ovp.dto.UserQueryDTO;
import com.ovp.dto.UserRegisterDTO;
import com.ovp.entity.User;
import com.ovp.result.PageResult;
import com.ovp.vo.UserLoginVO;
import com.ovp.vo.UserQueryVO;

import java.util.List;

public interface UserService {
    void registerUser(UserRegisterDTO userRegisterDTO);

    UserLoginVO login(UserLoginDTO userLoginDTO);

    User getUserInfo(Long userId);

    void deleteByUserId(Long userId);

    void updateUser(UserRegisterDTO userRegisterDTO);

    PageResult queryUserList(UserQueryDTO userQueryDTO);
}
