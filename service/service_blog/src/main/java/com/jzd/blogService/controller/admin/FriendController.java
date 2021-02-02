package com.jzd.blogService.controller.admin;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzd.blogService.entity.Friend;
import com.jzd.blogService.service.FriendService;
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
@Api(description = "友链管理")
@RestController
@CrossOrigin
@RequestMapping("/admin/blogService/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;

    @ApiOperation("所有图片列表")
    @GetMapping("/list")
    public R findAll(){
        List<Friend> list = friendService.list();
        return R.ok().data("items",list);
    }

    @ApiOperation("分页查询友链列表")
    @GetMapping("/list/{page}/{limit}")
    public R pageList(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录页数", required = true) @PathVariable Long limit){
        Page<Friend> friendPage = new Page<>(page,limit);
        Page<Friend> pageModel = friendService.page(friendPage);
        long total = pageModel.getTotal();
        List<Friend> records = pageModel.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation(value = "根据ID删除友链", notes = "根据ID删除友链")
    @DeleteMapping("/remove/{id}")
    public R removeById(@ApiParam(value = "讲师ID", required = true) @PathVariable Long id){
        boolean remove = friendService.removeById(id);
        if (remove){
            return R.ok().message("删除成功");
        }else{
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("新增友链")
    @PostMapping("/save")
    public R save(@ApiParam(value = "分类对象", required = true) @RequestBody Friend friend){
        boolean save = friendService.save(friend);
        if (save){
            return R.ok().message("新增成功");
        }else{
            return R.error().message("新增失败");
        }
    }

    @ApiOperation("更新友链")
    @PutMapping("/update")
    public R updateById(@RequestBody Friend friend){
        boolean update = friendService.updateById(friend);
        if (update){
            return R.ok().message("更新成功");
        }else{
            return R.error().message("更新失败");
        }
    }

    @ApiOperation("根据ID(获取)回显友链")
    @GetMapping("/getFriend/{id}")
    public R getFriendById(@ApiParam(value = "分类ID",required = true) @PathVariable Long id){
        Friend friend = friendService.getById(id);
        if (friend != null){
            return R.ok().data("item",friend);
        }else {
            return R.error().message("数据不存在");
        }
    }

}

