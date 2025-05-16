package com.ovp.entity;

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
 * 用户实体类
 */
public class User {
    private Long id; //用户id
    private String username; //账号
    private String password; //密码
    private String email; //邮箱
    private String avatarUrl; //头像url
    private Integer age; //年龄
    private String phone; //手机号
    private Integer status; //用户状态 0-正常 1-封禁
    private String role; //用户角色 0-普通用户 1-管理员
    private String nickname; //昵称
    private String gender; //性别
    private String bio; //个性签名
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //更新时间
}
