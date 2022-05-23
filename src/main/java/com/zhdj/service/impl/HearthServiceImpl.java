package com.zhdj.service.impl;

import com.zhdj.bean.Aspirations;
import com.zhdj.mappers.HearthMapper;
import com.zhdj.service.HearthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class HearthServiceImpl implements HearthService {

    @Autowired
    HearthMapper hearthMapper;

    @Override
    public List<Aspirations> YouSoulYouBeat(int page1, int page2) {
        try{
            return  hearthMapper.YouSoulYouBeat(page1,page2);
        }
        catch (Exception e){
            return null;
        }


    }

    @Override
    public List<Aspirations> MySoulMyBeat(int page1, int page2, int user_id) {
        try{
            return hearthMapper.MySoulMyBeat(page1,page2,user_id);
        }
        catch (Exception e){
            return null;
        }

    }


    @Override
    public int addMyWish(String content, Date time, int user_id) {
        try{
            return    hearthMapper.addMyWish(content,time,user_id);
        }
        catch (Exception e){
            return 0;
        }


    }
}
