package com.full.full.Chat;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private String content;
    private String sender ;
    private String date ;
    private String receiver ;
    private MessageType type ;
}
