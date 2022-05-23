package com.zhdj.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Aspirations {
    int id;
    int user_id;
    String content;
    @JSONField(name="time", format="dd/MM/yyyy")
    Date time;
}
