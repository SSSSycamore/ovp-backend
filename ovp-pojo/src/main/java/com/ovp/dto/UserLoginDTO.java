package com.ovp.dto;

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
public class UserLoginDTO {
    public String username;
    public String password;
}
