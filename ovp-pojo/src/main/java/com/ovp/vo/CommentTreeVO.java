package com.ovp.vo;

import com.ovp.entity.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

/**
 * 评论树形结构的VO类
 * 用于展示评论及其子评论
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "评论树形结构的VO类",
        title = "CommentTreeVO")
public class CommentTreeVO extends Comment {
    @Schema(description = "子评论列表")
    List<CommentTreeVO> childrenComments;
    @Schema(description = "当前用户是否点赞该评论")
    Boolean isLike; // 当前用户是否点赞该评论
    @Schema(description = "点赞数量")
    Integer likeCount; // 点赞数量
}
