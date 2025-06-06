package com.ovp.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**
 * 评论类
 */
public class Comment {
    @Schema(description = "评论ID")
    private Long id;
    @Schema(description = "视频ID")
    private Long videoId; // 视频ID
    @Schema(description = "评论者的用户ID")
    private Long userId; // 评论者的用户ID
    @Schema(description = "评论的父评论id, 如果是一级评论则为null")
    private Long parentId;  // 回复某条评论时使用
    @Schema(description = "评论内容")
    private String content; // 评论内容
    @Schema(description = "评论发表时间")
    private LocalDateTime createTime;
    @Schema(description = "评论更新时间")
    private LocalDateTime updateTime;
}
