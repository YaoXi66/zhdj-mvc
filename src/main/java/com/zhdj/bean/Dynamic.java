package com.zhdj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dynamic {

    private int user_id;

    private int dynamic_id;

    private String time ;

    private String content;

    private String type;



}
