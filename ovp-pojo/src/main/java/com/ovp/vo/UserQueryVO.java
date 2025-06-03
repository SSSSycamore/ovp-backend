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
@Schema(description = "搜索用户返回的用户信息")
/**
 * 用户简略信息
 */
public class UserQueryVO {
    @Schema(description = "主键值，用户ID")
    private Long id; // 用户ID
    @Schema(description = "用户名")
    private String username; // 用户名
    @Schema(description = "昵称")
    private String nickname; // 昵称
    @Schema(description = "头像URL")
    private String avatarUrl; // 头像URL
    @Schema(description = "个性签名")
    private String bio; // 个性签名
    @Schema(description = "年龄")
    private Integer age; // 年龄
    @Schema(description = "性别")
    private Integer gender; // 性别 1-男 2-女
    @Schema(description = "粉丝数")
    private Integer fansCount; // 粉丝数
    @Schema(description = "视频数")
    private Integer videoCount; // 视频数
    @Schema(description = "关注数")
    private Integer followCount; // 关注数
    @Schema(description = "是否已关注")
    private Boolean isFollow; // 是否已关注
}
