package com.zhdj.service.impl;

import com.zhdj.bean.Dynamic;
import com.zhdj.bean.Exam;
import com.zhdj.bean.Vr;
import com.zhdj.mappers.NewsMapper;
import com.zhdj.service.NewsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;


    @Override
    public Dynamic selectDynamicById(int id) {
        return newsMapper.selectDynamicById(id);
    }

    @Override
    public List<Dynamic> SelectDynamicList(int type, int page1, int page2) {
        return newsMapper.SelectDynamicList(type,page1,page2);
    }

    @Override
    public Integer addDynamicList(int user_id, int id, String time, String link, String type, String title, String preview) {

        return newsMapper.addDynamicList( user_id, id, time, link,  type, title, preview);
    }

    @Override
    public Integer addCollect(int user_id, Integer collection_id, String sub_title, Integer type, String title, String preview) {
        newsMapper.addCollect(user_id,collection_id,new Date(),type,title,preview);
        return null;
    }

    @Override
    public Integer updateHead(String filePath, int user_id) {
        newsMapper.updateHead(filePath,user_id);
        return null;
    }

    @Override
    public  List<Vr> SelectVrlist(Integer page1, Integer page2) {
        return newsMapper.SelectVrlist(page1,page2);
    }

    @Override
    public List<Exam> SelectEXamlist(Integer page1, Integer page2) {
        return newsMapper.SelectExamlist(page1,page2);
    }


}
