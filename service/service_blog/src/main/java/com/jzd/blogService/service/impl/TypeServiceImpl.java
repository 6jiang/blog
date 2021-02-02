package com.jzd.blogService.service.impl;

import com.jzd.blogService.entity.Type;
import com.jzd.blogService.mapper.TypeMapper;
import com.jzd.blogService.service.TypeService;
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
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

}
