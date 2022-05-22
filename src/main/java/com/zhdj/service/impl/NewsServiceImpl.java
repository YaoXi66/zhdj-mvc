package com.zhdj.service.impl;

import com.zhdj.bean.Dynamic;
import com.zhdj.mappers.NewsMapper;
import com.zhdj.service.NewsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;


    @Override
    public List<Dynamic> SelectDynamicList(int type, int page1, int page2) {
        return newsMapper.SelectDynamicList(type,page1,page2);
    }

    @Override
    public Integer addDynamicList(int user_id, int id, String time, String link, String type, String title, String preview) {

        return newsMapper.addDynamicList( user_id, id, time, link,  type, title, preview);
    }


}
