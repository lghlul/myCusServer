/**  
* Title: Config.java 
* Description:   
* @author ll  
* @date 2018年5月7日  
* @version 1.0  
*/  
package com.answer.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**  
* Title: Config 
* Description:   
* @author ll  
* @date 2018年5月7日  
*/
@Configuration  
//@EnableWebMvc//这个标注可以不加，如果有加，要extends WebMvcConfigurerAdapter  
@EnableWebSocket 
public class Config extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
	 public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {  
	        //1.注册WebSocket  
	        String websocket_url = "/websocket/socketServer";                        //设置websocket的地址  
	        registry.addHandler(webSocketHandler(), websocket_url).                          //注册Handler  
	                addInterceptors(new WebSocketHandshakeInterceptor()).setAllowedOrigins("*");                   //注册Interceptor  
	  
	    }  
	  
	    @Bean  
	    public TextWebSocketHandler webSocketHandler() {  
	        return new WebSocketHandler();  
	    }  
}
