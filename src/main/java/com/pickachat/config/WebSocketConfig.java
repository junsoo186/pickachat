package com.pickachat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 클라이언트에게 메시지를 전달할 때 사용할 경로 설정
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // 단체 채팅용 메시지 브로커
        registry.setApplicationDestinationPrefixes("/app"); // 클라이언트에서 서버로 보내는 메시지 경로
    }

    // WebSocket 연결 엔드포인트 등록 (SockJS 지원 및 모든 출처 허용)
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-chat")
                .setAllowedOrigins("*")
                .withSockJS();
    }
}