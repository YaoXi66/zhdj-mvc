package com.zhdj.service;

import com.zhdj.bean.Aspirations;

import java.util.Date;
import java.util.List;


public interface HearthService {
    List<Aspirations> YouSoulYouBeat(int page1, int page2);
    List<Aspirations> MySoulMyBeat( int page1,int page2,int user_id);


    int addMyWish(String content, Date time, int user_id);
}
