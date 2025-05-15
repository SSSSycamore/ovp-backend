package com.ovp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**
 * 视频标签对应类
 */
public class VideoTag {
    private Long id;
    private Long videoId; // 视频ID
    private Long tagId; // 标签ID
}
