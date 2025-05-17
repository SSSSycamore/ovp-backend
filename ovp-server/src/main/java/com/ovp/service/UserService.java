package com.ovp.service;

import com.ovp.dto.UserLoginDTO;
import com.ovp.dto.UserRegisterDTO;
import com.ovp.entity.User;
import com.ovp.vo.UserLoginVO;

public interface UserService {
    void registerUser(UserRegisterDTO userRegisterDTO);

    UserLoginVO login(UserLoginDTO userLoginDTO);

    User getUserInfo(Long userId);

    void deleteByUserId(Long userId);

    void updateUser(UserRegisterDTO userRegisterDTO);
}
