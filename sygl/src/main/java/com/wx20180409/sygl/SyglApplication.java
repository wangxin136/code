package com.wx20180409.sygl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wx20180409.sygl.dao")
public class SyglApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyglApplication.class, args);
	}
}
