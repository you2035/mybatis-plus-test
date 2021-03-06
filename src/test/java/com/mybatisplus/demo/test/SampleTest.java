package com.mybatisplus.demo.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mybatisplus.demo.Generate.entity.User;
import com.mybatisplus.demo.Generate.mapper.UserMapper;
import com.mybatisplus.demo.Generate.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


/**
 * @Auther: liuxin
 * @Date: 2020/3/16 12:24
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserServiceImpl userService;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);
		Assert.assertEquals(5, userList.size());
		userList.forEach(System.out::println);

	}

	@Test
	@Transactional //该注解操作数据库对数据库无污染
	public void testInsert(){
		User user = new User();
		user.setAge(38);
		user.setEmail("11232317312@qq.com");
		user.setName("李五");
		boolean isInsert = userService.save(user);
		System.out.println(isInsert);
	}

	@Test
	public void testSaveOrUpdate(){
		User user = new User();
//		user.setId((long) 6);
		user.setAge(1);
		user.setEmail("11111@163.com");
		user.setName("666");
		userService.saveOrUpdate(user);
	}

	@Test
	public void  testRemove(){
		QueryWrapper<User> wrapper = Wrappers.query();
		wrapper.between("age","1","17");
		userService.remove(wrapper);
	}

	@Test
	public void testWrapper(){
		QueryWrapper<User> wrapper = Wrappers.query();
		wrapper.lt("age","40");
		List<User> userList = userService.list(wrapper);
		userList.forEach(System.out::println);
	}

	@Test
	public void testLike(){
		QueryWrapper<User> wrapper = Wrappers.query();
		wrapper.ne("age","18").likeRight("name","李");
		List<User> users = userService.list(wrapper);
		users.forEach(System.out::println);
	}

	@Test
	public void testAllEq(){
		QueryWrapper<User> wrapper = Wrappers.query();
		Map<String,Object> map = new HashMap<>();
		map.put("age","18");
		map.put("email",null);
		wrapper.allEq(map);
		List<User> users = userService.list(wrapper);
		users.forEach(System.out::println);
	}

	@Test
	public void testUser(){
		List<User> users = userMapper.getAllUser();
		users.forEach(System.out::println);
	}
}
