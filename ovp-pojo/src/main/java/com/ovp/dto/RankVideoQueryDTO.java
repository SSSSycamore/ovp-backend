package com.ovp.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "排行榜视频查询参数")
public class RankVideoQueryDTO extends PageQueryDTO {
    @NotNull(message = "排行榜类型不能为空")
    @Schema(description = "排行榜类型：1-最新发布，2-最多观看，3-最多点赞")
    private Integer type; // 排行榜类型：1-最新发布，2-最多观看，3-最多点赞

    @Schema(description = "分区ID")
    @NotNull(message = "分区ID不能为空")
    private Long areaId; // 分区ID
}
