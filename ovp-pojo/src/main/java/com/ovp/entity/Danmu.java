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
 * 弹幕类
 */
public class Danmu {
    private Long id;
    private Long videoId;  // 视频ID
    private Long userId;  // 评论者的用户ID
    private String content;  // 弹幕内容
    private Double time;   // 视频时间点（秒）
    private LocalDateTime createTime;
}