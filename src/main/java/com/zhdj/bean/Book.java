package com.zhdj.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {


    private Integer book_id;
    private String title;
    private String author;
    private String img_src;
    private String introduce;


}
