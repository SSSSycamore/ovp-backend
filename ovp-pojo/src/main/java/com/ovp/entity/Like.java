package com.ovp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 点赞类
 */
@TableName("`like`")
public class Like {
    @Schema(description = "点赞ID")
    private Long id;
    @Schema(description = "用户ID")
    private Long userId; // 用户ID
    @Schema(description = "视频ID，如果点赞评论或弹幕就为空，其他同理")
    private Long videoId; // 视频ID，如果点赞评论或弹幕就为空，其他同理
    @Schema(description = "评论ID，如果点赞视频或弹幕就为空，其他同理")
    private Long commentId; // 评论ID
    @Schema(description = "弹幕ID，如果点赞视频或评论就为空，其他同理")
    private Long danmuId; // 弹幕ID
    @Schema(description = "点赞时间")
    private LocalDateTime createTime;
}