package com.ovp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 视频DTO
 * 用于接收前端传来的视频信息
 */
public class VideoDTO {
    @Schema(description = "分区id")
    @NotEmpty(message = "分区id不能为空")
    private Long area_id;

    @Schema(description = "视频标题")
    @NotEmpty(message = "视频标题不能为空")
    private String title;

    @Schema(description = "视频简介")
    private String description;

    @Schema(description = "视频封面")
    @NotEmpty(message = "视频封面不能为空")
    private String cover_url;

    @Schema(description = "视频地址")
    @NotEmpty(message = "视频地址不能为空")
    private String video_url;
}
