package com.jzd.blogService.controller.admin;


import com.jzd.blogService.entity.User;
import com.jzd.blogService.service.UserService;
import com.jzd.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jzd
 * @since 2020-10-07
 */
@Api(description = "用户管理")
@RestController
@RequestMapping("/admin/blogService/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("所有用户列表")
    @GetMapping("/list")
    public R list(){
        List<User> users = userService.list();
        return R.ok().data("items",users);
    }


}

