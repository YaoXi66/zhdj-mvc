package com.zhdj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer id;

    private String name;

    private String pass;

    private String email;

    private String sex;

    private String bg_img ;

    private String header_img ;

    private MultipartFile avatar;

}
