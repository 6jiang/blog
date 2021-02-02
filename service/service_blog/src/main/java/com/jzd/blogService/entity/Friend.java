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
@TableName("t_friend")
@ApiModel(value="Friend对象", description="")
public class Friend extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "友链地址")
    private String friendaddress;

    @ApiModelProperty(value = "友链名称")
    private String friendname;

    @ApiModelProperty(value = "友链头像地址")
    private String pictureaddress;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
