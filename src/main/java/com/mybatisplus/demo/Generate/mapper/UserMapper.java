package com.mybatisplus.demo.Generate.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplus.demo.Generate.entity.User;

/**
 * @Auther: liuxin
 * @Date: 2020/3/16 12:22
 * @Description:
 */
public interface UserMapper extends BaseMapper<User> {

	public Integer selectMaxAge();

	boolean save(User user);
}
