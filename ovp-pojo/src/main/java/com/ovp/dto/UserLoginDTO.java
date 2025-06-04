package com.ovp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 用户登录DTO
 * 用于接收前端传来的用户登录信息
 */
@Schema(description = "用户登录信息")
public class UserLoginDTO {
    @Schema(description = "用户名", example = "user123")
    public String username;
    @Schema(description = "密码", example = "password123")
    public String password;
}
