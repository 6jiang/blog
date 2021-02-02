package com.jzd.blogService.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.jzd.baseCommon.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jzd
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_comment")
@ApiModel(value="Comment对象", description="")
public class Comment extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "头像地址")
    private String avatar;

    @ApiModelProperty(value = "管理员评论")
    private Boolean adminComment;

    @ApiModelProperty(value = "被回复人昵称")
    private String replyName;

    @ApiModelProperty(value = "博客ID")
    private Long blogId;

    @ApiModelProperty(value = "父评论编号")
    private Long parentCommentId;

    @ApiModelProperty(value = "记录回复的编号，例如5回复的1，记录的是1")
    private Integer topCommentId;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
