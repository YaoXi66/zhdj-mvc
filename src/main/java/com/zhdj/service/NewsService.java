package com.zhdj.service;

import com.zhdj.bean.Dynamic;
import com.zhdj.bean.Vr;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface NewsService {

    Dynamic selectDynamicById(int id);
    List<Dynamic> SelectDynamicList(int type,int page1,int page2);
    Integer addDynamicList(int user_id,int id,String time,String link, String type,String title,String preview);

    Integer addCollect(int user_id,Integer collection_id,String sub_title,Integer type,String title,String preview);

    Integer updateHead(String filePath,int user_id);

    List<Vr> SelectVrlist(Integer page1, Integer page2);
}
