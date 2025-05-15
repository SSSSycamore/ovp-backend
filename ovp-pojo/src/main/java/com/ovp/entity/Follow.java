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
 * 关注类
 */
public class Follow {
    private Long id;
    private Long followerId;  // 关注者
    private Long followeeId; // 被关注者
    private LocalDateTime createTime;
}
