package com.ovp.service.impl;

import com.ovp.annotation.AutoFill;
import com.ovp.constant.MessageConstant;
import com.ovp.constant.UserRoleConstant;
import com.ovp.constant.UserStatusConstant;
import com.ovp.dto.UserLoginDTO;
import com.ovp.dto.UserRegisterDTO;
import com.ovp.entity.User;
import com.ovp.enumeration.OperationType;
import com.ovp.exception.AccountBannedException;
import com.ovp.exception.AccountExistException;
import com.ovp.exception.AccountNotFoundException;
import com.ovp.exception.PasswordErrorException;
import com.ovp.mapper.UserMapper;
import com.ovp.properties.JwtProperties;
import com.ovp.service.UserService;
import com.ovp.utils.JwtUtil;
import com.ovp.vo.UserLoginVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final JwtProperties jwtProperties;
    @Override
    @AutoFill(value = OperationType.INSERT)
    public void registerUser(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        BeanUtils.copyProperties(userRegisterDTO, user);
        user.setStatus(UserStatusConstant.NORMAL);
        user.setRole(UserRoleConstant.USER);
        user.setPassword(DigestUtils.md5DigestAsHex(userRegisterDTO.getPassword().getBytes()));
        userMapper.insert(user);
    }

    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(user.getPassword())) {
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        if (Objects.equals(user.getStatus(), UserStatusConstant.DISABLE)) {
            throw new AccountBannedException(MessageConstant.ACCOUNT_CONDITION_ERROR);
        }
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        String jwt = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);
        return UserLoginVO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .avatarUrl(user.getAvatarUrl())
                .nickname(user.getNickname())
                .token(jwt)
                .role(user.getRole())
                .build();
    }

    @Override
    public User getUserInfo(Long userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public void deleteByUserId(Long userId) {
        userMapper.deleteByUserId(userId);
    }

    @Override
    public void updateUser(UserRegisterDTO userRegisterDTO) {
        User user = userMapper.selectByUserId(userRegisterDTO.getId());
        if (user == null) {
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        if (Objects.equals(user.getStatus(), UserStatusConstant.DISABLE)) {
            throw new AccountBannedException(MessageConstant.ACCOUNT_CONDITION_ERROR);
        }
        User updatedUser = new User();
        BeanUtils.copyProperties(userRegisterDTO, updatedUser);
        userMapper.updateByUserId(updatedUser);
    }
}
