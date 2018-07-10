package com.zc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zc.dao")
public class WebStuApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebStuApplication.class, args);
	}
}
