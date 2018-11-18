package com.marshal.mcap.websocket.configuration;

import com.marshal.mcap.websocket.handler.WebSocketHandler;
import com.marshal.mcap.websocket.interceptor.WebSocketHandShakeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/11/15
 * Time: 20:55
 * Description:websocket配置类
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {

        //1.注册WebSocket
        String websocket_url = "/websocket/socketServer";                        //设置websocket的地址
        webSocketHandlerRegistry.addHandler(webSocketHandler(), websocket_url).                          //注册Handler
                addInterceptors(new WebSocketHandShakeInterceptor());                   //注册Interceptor

        //2.注册SockJS，提供SockJS支持(主要是兼容ie8)
        String sockjs_url = "/sockjs/socketServer";                              //设置sockjs的地址
        webSocketHandlerRegistry.addHandler(webSocketHandler(), sockjs_url).                            //注册Handler
                addInterceptors(new WebSocketHandShakeInterceptor()).                   //注册Interceptor
                withSockJS();

    }

    /**
     * 配置websocket处理器
     * @return
     */
    @Bean
    public TextWebSocketHandler webSocketHandler() {
        return new WebSocketHandler();
    }
}
