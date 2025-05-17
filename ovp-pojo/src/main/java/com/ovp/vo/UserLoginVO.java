package com.ovp.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginVO {
    private Long id;
    private String username;
    private String avatarUrl;
    private String nickname;
    private String token;
    private Integer role; // 角色：0普通用户，1管理员
}
