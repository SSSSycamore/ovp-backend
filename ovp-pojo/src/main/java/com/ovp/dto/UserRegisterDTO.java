package com.ovp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 用户注册DTO
 * 用于接收前端传来的用户注册信息
 */
@Schema(description = "用户注册信息")
public class UserRegisterDTO {
    @Schema(description = "用户ID，更新时需要提交", example = "1")
    private Long id; //用户ID，更新时需要提交
    @Schema(description = "用户名", example = "user123")
    private String username; //账号
    @Schema(description = "密码", example = "password123")
    private String password; //密码
    @Schema(description = "邮箱")
    private String email; //邮箱
    @Schema(description = "头像url")
    private String avatarUrl; //头像url
    @Schema(description = "年龄")
    private Integer age; //年龄
    @Schema(description = "生日")
    private LocalDate birthday; //生日
    @Schema(description = "地址")
    private String address; //地址
    @Schema(description = "手机号")
    private String phone; //手机号
    @Schema(description = "昵称")
    private String nickname; //昵称
    @Schema(description = "性别 1-男 2-女")
    private Integer gender; //性别 1-男 2-女
    @Schema(description = "个性签名")
    private String bio; //个性签名
}
