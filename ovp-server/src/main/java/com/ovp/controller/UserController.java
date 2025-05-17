package com.ovp.controller;

import com.ovp.dto.UserRegisterDTO;
import com.ovp.entity.User;
import com.ovp.result.Result;
import com.ovp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Api(tags = "用户功能")
@Slf4j
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    @ApiOperation("用户注册")
    public Result registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        log.info("用户注册:{}", userRegisterDTO);
        userService.registerUser(userRegisterDTO);
        return Result.success();
    }

    @GetMapping
    @ApiOperation("获取用户信息")
    public Result<User> getUserInfo(@RequestParam Long userId) {
        log.info("获取用户信息:{}", userId);
        return Result.success(userService.getUserInfo(userId));
    }

    @DeleteMapping
    @ApiOperation("用户注销")
    public Result deleteUser(@RequestParam Long userId) {
        log.info("用户注销:{}", userId);
        userService.deleteByUserId(userId);
        return Result.success();
    }

    @PostMapping
    @ApiOperation("修改用户信息")
    public Result updateUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        log.info("修改用户信息:{}", userRegisterDTO);
        userService.updateUser(userRegisterDTO);
        return Result.success();
    }
}



