package com.jzd.blogService.controller.admin;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzd.blogService.entity.Type;
import com.jzd.blogService.service.TypeService;
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
@Api(description = "分类管理")
@RestController
@RequestMapping("/admin/blogService/type")
@CrossOrigin
public class TypeController {
    @Autowired
    private TypeService typeService;

    @ApiOperation("所有分类列表")
    @GetMapping("/list")
    public R findAll(){
        List<Type> list = typeService.list();
        return R.ok().data("items",list);
    }

    @ApiOperation(value = "根据ID删除分类", notes = "根据ID删除分类")
    @DeleteMapping("/remove/{id}")
    public R removeById(@ApiParam(value = "讲师ID", required = true)@PathVariable String id){
        boolean result = typeService.removeById(id);
        if (result){
            return R.ok().message("删除成功");
        }else{
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("新增分类")
    @PostMapping("/save")
    public R save(@ApiParam(value = "分类对象", required = true) @RequestBody Type type){
        boolean save = typeService.save(type);
        if (save){
            return R.ok().message("新增成功");
        }else{
            return R.error().message("新增失败");
        }
    }

    @ApiOperation("更新分类")
    @PutMapping("/update")
    public R updateById(@ApiParam(value = "分类对象", required = true) @RequestBody Type type){
        boolean update = typeService.updateById(type);
        if (update){
            return R.ok().message("更新成功");
        }else{
            return R.error().message("更新失败");
        }
    }

    @ApiOperation("根据ID回显分类")
    @GetMapping("/getType/{id}")
    public R getTypeById(@ApiParam(value = "分类ID",required = true) @PathVariable String id){
        Type type = typeService.getById(id);
        if (type != null){
            return R.ok().data("item",type);
        }else {
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("分页查询分类")
    @GetMapping("/list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码",required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录页数",required = true)@PathVariable Long limit){
        Page<Type> pageParam = new Page<>(page,limit);
        Page<Type> pageModel = typeService.page(pageParam);
        long total = pageModel.getTotal();
        List<Type> records = pageModel.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }
}

