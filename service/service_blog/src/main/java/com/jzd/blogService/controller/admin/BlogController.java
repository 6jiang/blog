package com.jzd.blogService.controller.admin;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzd.blogService.entity.Blog;
import com.jzd.blogService.entity.form.BlogInfo;
import com.jzd.blogService.entity.vo.BlogQueryVo;
import com.jzd.blogService.service.BlogService;
import com.jzd.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jzd
 * @since 2020-10-07
 */
@Api(description = "博客管理")
@CrossOrigin
@RestController
@RequestMapping("/admin/blogService/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @ApiOperation("所有博客列表")
    @GetMapping("/list")
    public R findAll(){
        List<Blog> list = blogService.list();
        return R.ok().data("items",list);
    }

    @ApiOperation("分页查询博客列表")
    @GetMapping("/list/{page}/{limit}")
    public R pageList(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit,
                      @ApiParam(value = "博客列表查询对象", required = true) BlogQueryVo blogQueryVo){
        Page<Blog> pageModel = blogService.selectPage(page,limit,blogQueryVo);
        long total = pageModel.getTotal();
        List<Blog> records = pageModel.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation(value = "根据ID删除博客", notes = "根据ID删除博客")
    @DeleteMapping("/remove/{id}")
    public R removeById(@ApiParam(value = "讲师ID", required = true) @PathVariable Long id){
        boolean remove = blogService.removeById(id);
        if (remove){
            return R.ok().message("删除成功");
        }else{
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("根据ID(获取)回显博客数据")
    @GetMapping("/getBlog/{id}")
    public R getBlogById(@ApiParam(value = "分类ID",required = true) @PathVariable Long id){
        Blog blog = blogService.getById(id);
        if (blog != null){
            return R.ok().data("item",blog);
        }else {
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("更新博客")
    @PutMapping("/update")
    public R update(@RequestBody BlogInfo blog){
        blogService.updateBlogInfo(blog);
        return R.ok().message("保存成功");
    }

    @ApiOperation("新增博客")
    @PostMapping("/save")
    public R saveBlogInfo(
            @ApiParam(value = "课程基本信息", required = true)
            @RequestBody BlogInfo blogInfo){
        blogService.saveBlogInfo(blogInfo);
        return R.ok().message("保存成功");
    }

}

