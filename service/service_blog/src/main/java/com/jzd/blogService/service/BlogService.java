package com.jzd.blogService.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzd.blogService.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jzd.blogService.entity.form.BlogInfo;
import com.jzd.blogService.entity.vo.BlogQueryVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jzd
 * @since 2020-10-07
 */
public interface BlogService extends IService<Blog> {

    /**
     * 分页查询博客列表
     * @param page
     * @param limit
     * @param blogQueryVo
     * @return
     */
    Page<Blog> selectPage(Long page, Long limit, BlogQueryVo blogQueryVo);

    /**
     * 新增博客
     * @param blogInfo
     */
    void saveBlogInfo(BlogInfo blogInfo);

    /**
     * 修改博客
     * @param blog
     */
    void updateBlogInfo(BlogInfo blog);
}
