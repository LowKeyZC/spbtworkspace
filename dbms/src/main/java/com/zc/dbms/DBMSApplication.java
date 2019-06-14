package com.zc.dbms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO 未实现，AOP已实现，但真实查询全部走主库
 */
@MapperScan("com.zc.dao")
@SpringBootApplication
public class DBMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBMSApplication.class, args);
	}
}
