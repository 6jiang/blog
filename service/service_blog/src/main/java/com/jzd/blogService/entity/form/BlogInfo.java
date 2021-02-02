package com.jzd.blogService.entity.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author jzd
 * @Date 2021/1/19 16:58
 */
@Data
public class BlogInfo implements Serializable {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "博客标题")
    private String title;

    @ApiModelProperty(value = "文章内容")
    private String content;

    @ApiModelProperty(value = "首图地址")
    private String firstPicture;

    @ApiModelProperty(value = "文章类型，原创、转载")
    private String flag;

    @ApiModelProperty(value = "浏览次数")
    private Integer views;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "是否开启赞赏")
    private Boolean appreciation;

    @ApiModelProperty(value = "是否开启评论")
    private Boolean commentabled;

    @ApiModelProperty(value = "是否开启分享声明")
    private Boolean shareStatement;

    @ApiModelProperty(value = "是否发布")
    private Boolean published;

    @ApiModelProperty(value = "是否推荐")
    private Boolean recommend;

    @ApiModelProperty(value = "分类编号")
    private Long typeId;

    @ApiModelProperty(value = "用户编号")
    private Long userId;

    @ApiModelProperty(value = "评论数量")
    private Integer commentCount;

}
