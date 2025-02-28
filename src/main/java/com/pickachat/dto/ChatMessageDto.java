package com.pickachat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDto {
    private String sender;
    private String content;
    private String timestamp; // 서버에서 추가할 타임스탬프
}