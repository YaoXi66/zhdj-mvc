package com.zhdj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
    private int user_id;
    private int sender_id;
    private String content;
    private String time;
    private Integer message_id;

}
