package com.mybatisplus.demo.Generate.controller;

import com.mybatisplus.demo.Generate.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
