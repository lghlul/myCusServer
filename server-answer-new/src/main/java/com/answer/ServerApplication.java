package com.answer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@EnableTransactionManagement
@MapperScan(basePackages = "com.answer.mapper")
@SpringBootApplication
@EnableScheduling
public class ServerApplication{

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }


    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Bean
    public ValueOperations<String, String> valueOperations() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations;
    }
    @Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

}
