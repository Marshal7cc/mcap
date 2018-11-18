package com.marshal.mcap.websocket.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/11/15
 * Time: 21:01
 * Description:websocket连接前后事件
 */
public class WebSocketHandShakeInterceptor implements HandshakeInterceptor {

    /**
     * 连接前事件，将用户信息传入websocket session
     * @param request
     * @param response
     * @param webSocketHandler
     * @param attributes
     * @return
     * @throws Exception
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                String username = (String) session.getAttribute("username");  //这边获得登录时设置的唯一用户标识
                if (username == null) {
                    username = "未知" + session.getId();
                }
                /**
                 * attributes传入websocketSession
                 */
                attributes.put("username", username);  //将用户标识放入参数列表后，下一步的websocket处理器可以读取这里面的数据
            }
        }
        return true;

    }

    /**
     * 连接后时间
     * @param request
     * @param response
     * @param webSocketHandler
     * @param e
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler webSocketHandler, Exception e) {
//        System.out.println("After Handshake");
    }
}
