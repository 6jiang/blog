package com.jzd.blogService.controller.admin;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzd.blogService.entity.Picture;
import com.jzd.blogService.service.PictureService;
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
@Api(description = "图片管理")
@RestController
@CrossOrigin
@RequestMapping("/admin/blogService/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @ApiOperation("所有图片列表")
    @GetMapping("/list")
    public R findAll(){
        List<Picture> list = pictureService.list();
        return R.ok().data("items",list);
    }

    @ApiOperation("分页查询图片列表")
    @GetMapping("/list/{page}/{limit}")
    public R pageList(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录页数", required = true) @PathVariable Long limit){
        Page<Picture> pageParam = new Page<>(page,limit);
        Page<Picture> pageModel = pictureService.page(pageParam);
        long total = pageModel.getTotal();
        List<Picture> records = pageModel.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation("新增图片")
    @PostMapping("/save")
    public R save(@ApiParam(value = "图片对象", required = true) @RequestBody Picture picture){
        boolean save = pictureService.save(picture);
        if (save){
            return R.ok().message("新增成功");
        }else{
            return R.error().message("新增失败");
        }
    }

    @ApiOperation("根据ID删除图片")
    @DeleteMapping("/remove/{id}")
    public R removeById(@ApiParam(value = "图片ID", required = true) @PathVariable String id){
        boolean remove = pictureService.removeById(id);
        if (remove){
            return R.ok().message("删除成功");
        }else{
            return R.error().message("删除失败");
        }
    }

    @ApiOperation("根据ID更新图片")
    @PutMapping("/update")
    public R updateById(@ApiParam(value = "图片对象", required = true) @RequestBody Picture picture){
        boolean update = pictureService.updateById(picture);
        if (update){
            return R.ok().message("更新成功");
        }else{
            return R.error().message("更新失败");
        }
    }

    @ApiOperation("根据ID获取（回显）图片")
    @GetMapping("/getPicture/{id}")
    public R getPictureById(@ApiParam(value = "图片ID",required = true) @PathVariable Long id){
        Picture picture = pictureService.getById(id);
        if (picture != null){
            return R.ok().data("item",picture);
        }else {
            return R.error().message("数据不存在");
        }
    }

}

