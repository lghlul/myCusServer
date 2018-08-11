/**  
* Title: WebSocketHandshakeInterceptor.java 
* Description:   
* @author ll  
* @date 2018年5月7日  
* @version 1.0  
*/  
package com.answer.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;


/**  
* Title: WebSocketHandshakeInterceptor 
* Description:   
* @author ll  
* @date 2018年5月7日  
*/
@Component
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor{
	  
	
	    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {  
	    	if (request instanceof ServletServerHttpRequest) {  
	            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request; 
	            String wxSession = servletRequest.getServletRequest().getParameter("wxSession");
	            if(wxSession == null){
	            	return false;
	            }else{
	            	HttpSession session = servletRequest.getServletRequest().getSession(true);  
		            if (session != null) {  
		                //使用userName区分WebSocketHandler，以便定向发送消息  
		                String userName = (String) session.getAttribute("WEBSOCKET_SESSION_ID");  
		                if (userName == null) {  
		                    userName = wxSession;  
		                }  
		                attributes.put("WEBSOCKET_SESSION_ID", userName);  
		            } 
		            return true;  
	            }
	            
	        } 
	    	return false;
	        
	    }  
	  
	    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {  
	        System.out.println("After Handshake");  
	    }  
}
