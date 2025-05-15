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
 * 标签类
 */
public class Tag {
    private Long id;
    private String name; // 标签名称
    private String description; // 标签描述
}
