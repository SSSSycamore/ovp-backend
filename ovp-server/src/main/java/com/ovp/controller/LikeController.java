package com.ovp.controller;

import com.ovp.result.Result;
import com.ovp.service.LikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/likes")
@Slf4j
@Tag(name = "点赞功能")
public class LikeController {
    private final LikeService likeService;

    @Operation(summary = "点赞视频功能")
    @PostMapping("/video/{videoId}")
    public Result likeVideo(@PathVariable Long videoId){
        log.info("点赞视频:{}", videoId);
        likeService.likeVideo(videoId);
        return Result.success();
    }
}
