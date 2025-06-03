package com.ovp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 点赞类
 */
@TableName("`like`")
public class Like {
    private Long id;
    private Long userId; // 用户ID
    private Long videoId; // 视频ID，如果点赞评论或弹幕就为空，其他同理
    private Long commentId; // 评论ID
    private Long danmuId; // 弹幕ID
    private LocalDateTime createTime;
}