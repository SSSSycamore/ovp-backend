package com.ovp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 分页查询DTO
 * 用于接收前端传来的分页查询参数
 */
@Schema(description = "分页查询参数")
public class PageQueryDTO {
    @Schema(description = "当前页码，默认为1")
    private Integer pageNo = 1; // 当前页码，默认为1
    @Schema(description = "每页显示的记录数，默认为10")
    private Integer pageSize = 10; // 每页显示的记录数，默认为10
}
