package com.jzd.blogService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author jzd
 * @Date 2020/10/7 16:48
 */
@SpringBootApplication
@ComponentScan({"com.jzd"})
public class BlogServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogServiceApplication.class, args);
    }
}
