package com.zhdj.service.impl;

import com.zhdj.bean.Dynamic;
import com.zhdj.mappers.NewsMapper;
import com.zhdj.service.NewsService;
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
}
