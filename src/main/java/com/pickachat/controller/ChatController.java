package com.pickachat.controller;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.pickachat.dto.ChatMessageDto;
import com.pickachat.utils.formatter.DateTimeUtil;

@Controller
public class ChatController {

    // 클라이언트가 "/app/chat.sendMessage"로 메시지를 보내면 이 메서드가 호출됨
    // 처리 후 "/topic/public"로 브로드캐스트
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessageDto sendMessage(ChatMessageDto messageDto) {
        // 현재 시간을 포맷하여 타임스탬프로 설정
        messageDto.setTimestamp(DateTimeUtil.formatDefault(LocalDateTime.now()));
        return messageDto;
    }
}