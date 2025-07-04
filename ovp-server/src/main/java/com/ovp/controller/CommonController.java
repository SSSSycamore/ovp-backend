package com.ovp.controller;

import com.ovp.dto.UserLoginDTO;
import com.ovp.exception.FileUploadFailedException;
import com.ovp.result.Result;
import com.ovp.service.UserService;
import com.ovp.utils.AliOssUtil;
import com.ovp.vo.UserLoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
@Tag(name = "公共接口")
public class CommonController {
    private final UserService userService;
    private final AliOssUtil aliOssUtil;

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("用户登录:{}", userLoginDTO);
        return Result.success(userService.login(userLoginDTO));
    }

    @PostMapping("/upload")
    @Operation(summary ="文件上传")
    public Result<String> upload(MultipartFile file){
        try {
            log.info("文件上传:{}", file.getOriginalFilename());
            String url = aliOssUtil.upload(file.getBytes(), file.getOriginalFilename());
            return Result.success(url);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传文件失败:{}", e.getMessage());
            throw new FileUploadFailedException("文件上传失败");
        }
    }
}
