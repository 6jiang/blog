package com.jzd.blogService.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzd.blogService.entity.Blog;
import com.jzd.blogService.entity.form.BlogInfo;
import com.jzd.blogService.entity.vo.BlogQueryVo;
import com.jzd.blogService.mapper.BlogMapper;
import com.jzd.blogService.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;



/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jzd
 * @since 2020-10-07
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    /**
     * 分页查询博客列表
     * @param page
     * @param limit
     * @param blogQueryVo
     * @return
     */
    @Override
    public Page<Blog> selectPage(Long page, Long limit, BlogQueryVo blogQueryVo) {
        Page<Blog> pageParam = new Page<>(page,limit);
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        if (blogQueryVo == null){
            return baseMapper.selectPage(pageParam,queryWrapper);
        }
        String title = blogQueryVo.getTitle();
        Boolean published = blogQueryVo.getPublished();
        Boolean recommend = blogQueryVo.getRecommend();
        String gmtCreate = blogQueryVo.getGmtCreate();
        String gmtModified = blogQueryVo.getGmtModified();

        if (!StringUtils.isEmpty(title)) {
            //左%会使索引失效
            queryWrapper.likeRight("title", title);
        }

        if (published != null) {
            queryWrapper.eq("published", published);
        }

        if (recommend != null) {
            queryWrapper.eq("recommend", recommend);
        }

        if (!StringUtils.isEmpty(gmtCreate)) {
            queryWrapper.ge("gmt_create", gmtCreate);
        }

        if (!StringUtils.isEmpty(gmtModified)) {
            queryWrapper.le("gmt_modified", gmtModified);
        }

        return baseMapper.selectPage(pageParam,queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveBlogInfo(BlogInfo blogInfo) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogInfo,blog);
        baseMapper.insert(blog);

    }

    @Override
    public void updateBlogInfo(BlogInfo blog) {
        Blog blogs = new Blog();
        BeanUtils.copyProperties(blog,blogs);
        baseMapper.updateById(blogs);
    }
}
