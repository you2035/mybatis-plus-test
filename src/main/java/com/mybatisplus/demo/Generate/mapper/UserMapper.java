package com.mybatisplus.demo.Generate.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mybatisplus.demo.Generate.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: liuxin
 * @Date: 2020/3/16 12:22
 * @Description:
 */
public interface UserMapper extends BaseMapper<User> {

	public Integer selectMaxAge();

	@Select("select * from user")
	public List<User> getAllUser();

	Object page(IPage<User> page, QueryWrapper<User> wrapper);
}
