package com.full.full.Chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    public ChatController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    private SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(
          @Payload ChatMessage chatMessage
    ){
        return chatMessage;
    }
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor
    ){
        //ceci pour ajouter un username
        headerAccessor.getSessionAttributes().put("username",chatMessage.getSender());
        return chatMessage;
    }
    @MessageMapping("/private-message")
    public ChatMessage receivePrivateMessage(@Payload ChatMessage chatMessage){
         simpMessagingTemplate.convertAndSendToUser(chatMessage.getReceiver(),"/private",chatMessage);
     return chatMessage;
    }
}
