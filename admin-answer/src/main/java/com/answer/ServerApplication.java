package com.answer;

import com.answer.Interceptor.SessionInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@MapperScan(basePackages="com.answer.mapper")
@ComponentScan(basePackages = {"com.answer"})
@SpringBootApplication
public class ServerApplication extends WebMvcConfigurerAdapter {

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		//添加拦截器
		registry.addInterceptor(new SessionInterceptor())
				.addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
