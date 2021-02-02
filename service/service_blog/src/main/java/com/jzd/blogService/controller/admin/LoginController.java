package com.jzd.blogService.controller.admin;

import com.jzd.result.R;
import org.springframework.web.bind.annotation.*;

/**
 * @Author jzd
 * @Date 2020/10/17 12:47
 */

@RestController
@CrossOrigin
@RequestMapping("/user")
public class LoginController {
    /**
     * 登录
     * @return
     */
    @PostMapping("/login")
    public R login() {
        return R.ok().data("token","admin");
    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/info")
    public R info() {
        return R.ok()
                .data("roles","[admin]")
                .data("name","admin")
                .data("avatar","https://picsum.photos/id/1010/367/267");
    }

    /**
     * 退出
     * @return
     */
    @PostMapping("/logout")
    public R logout(){
        return R.ok();
    }
}
