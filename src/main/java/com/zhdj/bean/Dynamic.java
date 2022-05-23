package com.zhdj.bean;

import com.alibaba.fastjson.annotation.JSONField;
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

    @JSONField(name = "id")
    private int id;

    @JSONField(name = "sub_title")
    private String time ;

    private String link;
    private String title;

    private Integer type;

    private String preview;



}
