package com.jzd.blogService.service.impl;

import com.jzd.blogService.entity.Comment;
import com.jzd.blogService.mapper.CommentMapper;
import com.jzd.blogService.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
