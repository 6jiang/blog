package com.jzd.blogService.service.impl;

import com.jzd.blogService.entity.Message;
import com.jzd.blogService.mapper.MessageMapper;
import com.jzd.blogService.service.MessageService;
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
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
