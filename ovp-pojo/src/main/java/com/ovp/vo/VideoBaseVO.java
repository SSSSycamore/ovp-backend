package com.ovp.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoBaseVO {
    private Long id; // 视频ID
    private String title; // 视频标题
    private String coverUrl; // 视频封面URL
    private String userAvatarUrl; // 用户头像URL
    private String userName; // 用户名
    private Integer viewCount; // 播放量
    private Integer likeCount; // 点赞数
    private Boolean isLike; // 是否点赞（当前用户是否点赞）
    private Double durationSeconds; // 视频时长（秒）
}
