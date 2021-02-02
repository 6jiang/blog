package com.jzd.blogService.service.impl;

import com.jzd.blogService.entity.User;
import com.jzd.blogService.mapper.UserMapper;
import com.jzd.blogService.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jzd
 * @since 2020-10-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
