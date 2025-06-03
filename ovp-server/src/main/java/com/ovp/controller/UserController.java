package com.ovp.controller;

import com.ovp.context.BaseContext;
import com.ovp.result.PageResult;
import com.ovp.dto.UserQueryDTO;
import com.ovp.dto.UserRegisterDTO;
import com.ovp.entity.User;
import com.ovp.result.Result;
import com.ovp.service.UserService;
import com.ovp.vo.UserQueryVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "用户功能")
@Slf4j
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    @Operation(summary ="用户注册")
    public Result registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        log.info("用户注册:{}", userRegisterDTO);
        userService.registerUser(userRegisterDTO);
        return Result.success();
    }

    @GetMapping
    @Operation(summary ="获取详细当前用户信息")
    public Result<User> getUserInfo() {
        Long userId = BaseContext.getCurrentId();
        log.info("获取用户信息:{}", userId);
        return Result.success(userService.getUserInfo(userId));
    }

    @DeleteMapping
    @Operation(summary ="用户注销")
    public Result deleteUser(@RequestParam Long userId) {
        log.info("用户注销:{}", userId);
        userService.deleteByUserId(userId);
        return Result.success();
    }

    @PostMapping
    @Operation(summary ="修改用户信息")
    public Result updateUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        log.info("修改用户信息:{}", userRegisterDTO);
        userService.updateUser(userRegisterDTO);
        return Result.success();
    }

    @GetMapping("/list")
    @Operation(summary ="根据参数分页排序查询用户列表")
    public Result<PageResult> queryUserList(UserQueryDTO userQueryDTO) {
        log.info("根据参数分页排序查询用户列表:{}", userQueryDTO);
        PageResult pageResult = userService.queryUserList(userQueryDTO);
        return Result.success(pageResult);
    }


}



