package com.ovp.entity;

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
    private Long id;
    private Long videoId; // 视频ID
    private Long userId; // 评论者的用户ID
    private Long parentId;  // 回复某条评论时使用
    private String content; // 评论内容
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
