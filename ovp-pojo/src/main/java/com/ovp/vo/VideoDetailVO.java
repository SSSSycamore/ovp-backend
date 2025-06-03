package com.ovp.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoDetailVO {
    private Long id;
    private Long userId;    // 上传者的用户ID
    private Long areaId;  // 视频分区ID
    private String title;  //视频标题
    private String description; //视频描述
    private String coverUrl; //视频封面URL
    private String videoUrl; //视频URL
    private Long viewCount; //播放数
    private Long likeCount;  //点赞数
    private Long commentCount; //评论数
    private LocalDateTime uploadTime;  //上传时间
    private Boolean isLike; // 当前用户是否点赞
}
