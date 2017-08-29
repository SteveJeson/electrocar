package com.zdzc.electrocar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "com.zdzc.electrocar.mapper")
public class ElectrocarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectrocarApplication.class, args);
	}
}
