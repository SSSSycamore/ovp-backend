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
 * 分区类
 */
public class Area {
    private Long id;
    private String name;       // 分区名称
    private String description; // 分区描述
}
