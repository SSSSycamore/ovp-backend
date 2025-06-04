package com.ovp.controller;

import cn.hutool.db.PageResult;
import com.ovp.dto.RankVideoQueryDTO;
import com.ovp.dto.VideoDTO;
import com.ovp.dto.PageQueryDTO;
import com.ovp.result.Result;
import com.ovp.service.VideoService;

import com.ovp.vo.VideoBaseVO;
import com.ovp.vo.VideoDetailVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/videos")
@RestController
@Slf4j
@Tag(name = "视频功能")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

    @Operation(summary = "新建视频功能")
    @PostMapping
    public Result createVideo(@RequestBody @Validated VideoDTO videoDTO){
        log.info("新建视频:{}", videoDTO);
        videoService.createVideo(videoDTO);
        return Result.success();
    }

    @Operation(summary ="添加播放量")
    @PutMapping("/{videoId}/views")
    public Result addVideoViews(@PathVariable Long videoId) {
        log.info("添加视频播放量:{}", videoId);
        videoService.addVideoViews(videoId);
        return Result.success();
    }

    @Operation(summary = "查询视频详细信息")
    @GetMapping("/{videoId}")
    public Result<VideoDetailVO> getVideoById(@PathVariable Long videoId) {
        log.info("查询视频详细信息:{}", videoId);
        VideoDetailVO videoDetailVO = videoService.getVideoDetailById(videoId);
        return Result.success(videoDetailVO);
    }

    @Operation(summary = "分页查询视频")
    @GetMapping("/page")
    public Result<List<VideoBaseVO>> pageQuery(PageQueryDTO videoPageQueryDTO) {
        log.info("分页查询视频:{}", videoPageQueryDTO);
        List<VideoBaseVO> pageResult = videoService.pageQuery(videoPageQueryDTO);
        return Result.success(pageResult);
    }

    @Operation(summary = "排行榜查询视频")
    @PostMapping("/rank")
    public Result<List<VideoBaseVO>> rankQuery(@RequestBody @Validated RankVideoQueryDTO rankVideoQueryDTO){
        log.info("排行榜查询视频:{}", rankVideoQueryDTO);
        return Result.success(videoService.rankQuery(rankVideoQueryDTO));
    }
}
