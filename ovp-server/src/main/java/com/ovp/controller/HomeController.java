package com.ovp.controller;

import com.ovp.result.Result;
import com.ovp.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "首页接口", description = "首页相关接口")
@RestController
@RequestMapping("/home")
@Slf4j
@RequiredArgsConstructor
public class HomeController {
    private final VideoService videoService;

    @GetMapping("/recommended-image")
    @Operation(description = "获取推荐图片")
    public Result<String> getRecommendedImage() {
        log.info("获取推荐图片");
        // 这里可以返回一个推荐图片的URL或Base64编码的图片数据
        return Result.success(
                "https://sssycamore.oss-cn-beijing.aliyuncs.com/2025/MyVideo%E5%B9%BF%E5%91%8A%E4%BD%8D.png");
    }

    @GetMapping("/featured-image")
    @Operation(description = "获取精选图片")
    public Result<String> getFeaturedImage() {
        log.info("获取精选图片");
        // 这里可以返回一个推荐图片的URL或Base64编码的图片数据
        return Result.success(
                "https://sssycamore.oss-cn-beijing.aliyuncs.com/2025/%E5%B9%BF%E5%91%8A%E4%BD%8D2.png");
    }
}
