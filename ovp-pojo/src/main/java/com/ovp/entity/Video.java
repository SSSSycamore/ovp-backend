package com.ovp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**
 * 视频实体类
 */
@TableName(value = "video", autoResultMap = true)
public class Video {
    private Long id;
    private Long userId;  // 上传者的用户ID
    private Long areaId;  // 视频分区ID
    private String title;  //视频标题
    private String description; //视频描述
    private String coverUrl; //视频封面URL
    private String videoUrl; //视频URL
    private Long viewCount; //播放数
    private Long likeCount;  //点赞数
    private Long favoriteCount; //收藏数
    private Long commentCount; //评论数
    private LocalDateTime uploadTime;  //上传时间
    private LocalDateTime updateTime;  //更新时间
    private Integer status; // 审核状态，如 0-待审核，1-审核通过，2-审核不通过，3-已下架
    private Double durationSeconds; // 视频时长（秒）
    @TableField(exist = false)
    private List<Tag> tags;   //视频标签集合
}
