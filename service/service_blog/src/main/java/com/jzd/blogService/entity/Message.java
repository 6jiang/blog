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
@TableName("t_message")
@ApiModel(value="Message对象", description="留言")
public class Message extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "留言内容")
    private String content;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "父留言ID")
    private Long parentMessageId;

    @ApiModelProperty(value = "管理员留言")
    private Boolean adminMessage;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
