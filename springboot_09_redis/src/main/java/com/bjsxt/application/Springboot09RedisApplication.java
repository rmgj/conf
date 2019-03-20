package com.bjsxt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //开启spring的缓存功能
public class Springboot09RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot09RedisApplication.class, args);
	}

}
