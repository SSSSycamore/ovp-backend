package com.ovp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 用户注册DTO
 * 用于接收前端传来的用户注册信息
 */
public class UserRegisterDTO {
    private Long id;
    private String username; //账号
    private String password; //密码
    private String email; //邮箱
    private String avatarUrl; //头像url
    private Integer age; //年龄
    private String birthday; //生日
    private String address; //地址
    private String phone; //手机号
    private String nickname; //昵称
    private Integer gender; //性别 1-男 2-女
    private String bio; //个性签名
}
