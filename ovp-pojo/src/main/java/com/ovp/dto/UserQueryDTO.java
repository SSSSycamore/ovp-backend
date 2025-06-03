package com.ovp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 用户查询DTO
 * 用于接收前端传来的用户查询参数
 */
public class UserQueryDTO {
    private Integer page = 1;
    private Integer pageSize = 5;
    private String sortBy = "fansCount";// 排序字段
    private Boolean isAsc = false;// 升序或降序
    private String nickname;
}
