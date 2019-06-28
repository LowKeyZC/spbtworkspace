package com.zc.spbt2xstu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.zc.dao")
public class Spbt2xstuApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spbt2xstuApplication.class, args);
    }

}
