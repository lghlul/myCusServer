package com.lu;

import com.lu.utils.PropertiesUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@MapperScan(basePackages="com.lu.mapper")
@ComponentScan(basePackages = {"com.lu"})
@SpringBootApplication
public class ServerApplication {

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		PropertiesUtil.initProperties();
		SpringApplication.run(ServerApplication.class, args);
	}
}
