package com.full.full.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {
    private String message;
    private String senderName;
    private String date ;
    private String receiverName ;
    private Status status ;

}
