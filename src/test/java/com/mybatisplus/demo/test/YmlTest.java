package com.mybatisplus.demo.test;

import com.mybatisplus.demo.util.YmlUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.LinkedHashMap;

/**
 * @Auther: liuxin
 * @Date: 2020/3/16 16:32
 * @Description:
 */
@RunWith(JUnit4.class)
public class YmlTest {

	@Test
	public void getYml(){

		LinkedHashMap<String,String> map = (LinkedHashMap<String, String>) YmlUtil.getInstance().getValueByKey("spring","datasource");

		String url = map.get("url");

		System.out.println(url);



	}
}
