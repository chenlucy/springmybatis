/*  
 * Copyright 2010-2017 Tocean Group.  
 * 版权：商业代码，未经许可，禁止任何形式拷贝、传播及使用
 * 文件名：SwaggerConfig.java
 * 描述：  
 * 修改人：Arber.Lee  
 * 修改时间：2017年11月17日  
 * 跟踪单号：  
 * 修改单号：  
 * 修改内容：  
 */
package com.example.demo.service.impl;

import com.example.demo.core.ServiceException;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;


/**
 * Created by Corey. on 2018/07/10.
 * @author corey
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
@Slf4j
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    @Autowired
    private UserMapper userMapper;

}
