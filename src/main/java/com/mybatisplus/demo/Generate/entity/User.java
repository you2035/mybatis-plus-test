package com.mybatisplus.demo.Generate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: liuxin
 * @Date: 2020/3/16 12:21
 * @Description:
 */
@Data
@Getter
@Setter
@KeySequence("SEQ_USER")
@TableName("user")
public class User {

	@TableId(value = "id", type = IdType.INPUT)
	private Long id;
	private String name;
	private Integer age;
	private String email;
}
