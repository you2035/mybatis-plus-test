package com.mybatisplus.demo.test;

import com.mybatisplus.demo.Generate.entity.User;
import com.mybatisplus.demo.Generate.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);
		Assert.assertEquals(5, userList.size());
		userList.forEach(System.out::println);
	}
}
