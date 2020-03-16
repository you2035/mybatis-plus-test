package com.mybatisplus.demo.util;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class YmlUtil {

	private static Map<String, Map<String, Object>> properties;

	private YmlUtil() {
		if (SingletonHolder.instance != null) {
			throw new IllegalStateException();
		}
	}

	/**
	 * use static inner class  achieve singleton
	 */
	private static class SingletonHolder {
		private static YmlUtil instance = new YmlUtil();
	}

	public static YmlUtil getInstance() {
		return SingletonHolder.instance;
	}

	//init property when class is loaded
	static {

		InputStream in = null;
		try {
			properties = new HashMap<>();
			Yaml yaml = new Yaml();
			in = YmlUtil.class.getClassLoader().getResourceAsStream("application.yml");
			properties = yaml.loadAs(in, HashMap.class);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * get yaml property
	 *
	 * @param key
	 * @return
	 */
	public Object getValueByKey(String root, String key) {

		Map<String, Object> rootProperty = properties.get(root);
		return rootProperty.getOrDefault(key, "");
	}
}

