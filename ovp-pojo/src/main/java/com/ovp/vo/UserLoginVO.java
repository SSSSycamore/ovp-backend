package com.ovp.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "用户登录返回对象")
public class UserLoginVO {
    @Schema(description = "主键值,用户ID")
    private Long id;
    @Schema(description = "账号")
    private String username;
    @Schema(description = "头像URL")
    private String avatarUrl;
    @Schema(description = "昵称")
    private String nickname;
    @Schema(description = "jwt令牌")
    private String token;
    @Schema(description = "角色：0普通用户，1管理员")
    private Integer role; // 角色：0普通用户，1管理员
}
