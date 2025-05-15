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
 * 收藏类
 */
public class Favorite {
    private Long id;
    private Long userId; // 用户ID
    private Long videoId; // 视频ID
    private LocalDateTime createTime;
}
