package com.answer;

import com.alibaba.fastjson.JSON;
import com.answer.Interceptor.SessionInterceptor;
import com.answer.domain.Config;
import com.answer.domain.TrainConfig;
import com.answer.mapper.TConfigMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableTransactionManagement
@MapperScan(basePackages = "com.answer.mapper")
@SpringBootApplication
public class ServerApplication extends WebMvcConfigurerAdapter {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // todo 测试使用
        //添加拦截器
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Bean
    public ValueOperations<String, String> valueOperations() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations;
    }


}
