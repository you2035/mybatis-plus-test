package com.mybatisplus.demo.Generate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplus.demo.Generate.entity.User;
import com.mybatisplus.demo.Generate.mapper.UserMapper;
import com.mybatisplus.demo.Generate.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
