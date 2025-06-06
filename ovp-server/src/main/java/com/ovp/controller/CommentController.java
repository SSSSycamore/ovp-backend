package com.ovp.controller;

import com.ovp.context.BaseContext;
import com.ovp.entity.Comment;
import com.ovp.result.Result;
import com.ovp.service.CommentService;
import com.ovp.vo.CommentTreeVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/comments")
@Tag(name = "评论功能", description = "评论相关接口")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @Operation(summary = "查询视频评论")
    @GetMapping("/videoId/{videoId}")
    public Result<List<CommentTreeVO>> queryVideoComments(@PathVariable Long videoId){
        return Result.success(commentService.queryVideoComments(videoId));
    }

    @Operation(summary = "发表评论")
    @PostMapping("/create")
    public Result createComment(@RequestBody Comment comment) {
        commentService.save(comment);
        return Result.success("评论成功");
    }
}
