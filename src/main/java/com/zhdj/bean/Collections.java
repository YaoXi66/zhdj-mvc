package com.zhdj.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class Collections {

    private Integer user_id;
    private String collection_id;
    private String title;
    private String sub_title;
    private String preview;
    private Integer type;
    private String time;
    private String mes;


    public Collections(Integer user_id, String collection_id, Integer type, String time) {
        this.user_id = user_id;
        this.collection_id = collection_id;
        this.type = type;
        this.time = time;
    }


}
