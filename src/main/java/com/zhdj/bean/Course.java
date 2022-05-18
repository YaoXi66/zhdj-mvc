package com.zhdj.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

    private String name;
    private String number;
    private String man;
    private String link;
    private String time;

}
