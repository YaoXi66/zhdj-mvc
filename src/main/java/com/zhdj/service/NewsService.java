package com.zhdj.service;

import com.zhdj.bean.Dynamic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface NewsService {

    List<Dynamic> SelectDynamicList(int type,int page1,int page2);
    Integer addDynamicList(int user_id,int id,String time,String link, String type,String title,String preview);
}
