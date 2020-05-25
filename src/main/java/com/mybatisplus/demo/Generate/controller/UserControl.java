package com.mybatisplus.demo.Generate.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.demo.Generate.entity.User;
import com.mybatisplus.demo.Generate.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: liuxin
 * @Date: 2020/3/16 14:22
 * @Description:
 */
@Controller
public class UserControl {

	@Autowired
	private UserMapper userMapper;
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		Integer id = userMapper.selectMaxAge();
		return id+"";
	}


		@RequestMapping(value = "/findAll",method = RequestMethod.POST)
		public Object findAll(){

			Integer pageNo = 1;
			Integer pageSize = 10;
			IPage<User> page = new Page<>(pageNo, pageSize);
			QueryWrapper<User> wrapper = new QueryWrapper<>();

			return userMapper.page(page,wrapper);
		}

}
