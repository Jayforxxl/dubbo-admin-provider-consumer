package com.jay.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableDubbo //开启基于注解的Dubbo功能
public class BootOrderServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootOrderServiceProviderApplication.class, args);
	}
}
