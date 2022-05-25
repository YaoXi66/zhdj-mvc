package com.zhdj.service.impl;


import com.zhdj.bean.*;
import com.zhdj.mappers.AllMapper;
import com.zhdj.service.AllServlet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServletImpl implements AllServlet {

    @Resource
    private AllMapper allMapper;

    @Override
    public List<Dynamic> selectDynamic(int currentPage, int pageSize,int type) {

//        调用方法
        List<Dynamic> dynamics = allMapper.selectDynamic(currentPage,pageSize,type);

        return dynamics;
    }

    @Override
    public void addUser(User user) {
//        调用方法
        allMapper.addUser(user);

    }

    @Override
    public User selectUser(String name, String pass) {

//        调用方法
        User users = allMapper.selectUser(name,pass);

        return users;
    }
//
    @Override
    public User selectByUsername(String name) {

//        调用方法
        User users = allMapper.selectByUsername(name);

        return users;
    }

    @Override
    public User selectById(int id) {

    //        调用方法
        User users = allMapper.selectById(id);

        return users;
    }
//
    @Override
    public void addCollection(Collections collection) {

//        调用方法
        allMapper.addCollection(collection);

    }

    @Override
    public List<Collections> selectCollectionsId(int currentPage, int pageSize, int user_id) {

//        调用方法
        List<Collections> rows = allMapper.selectCollectionsId(currentPage,pageSize,user_id);

        return rows;
    }

    @Override
    public void update(User user){
        //4. 调用方法
        allMapper.update(user);

    }

    @Override
    public void updateUserImg(User user){

        //4. 调用方法
        allMapper.updateUserImg(user);


    }

    @Override
    public void insertFeedback(FeedBack feedBack) {

        allMapper.insertFeedback(feedBack);

    }

    @Override
    public void insertBook(Book book) {

        allMapper.insertBook(book);

    }

    @Override
    public List<Book> selectBook(int begin, int size) {

        List<Book> books = allMapper.selectBook(begin, size);

        return books;

    }

    @Override
    public void insertDynamic(Dynamic dynamic) {

        allMapper.insertDynamic(dynamic);

    }

    @Override
    public void insertCommunication(Communication communication) {

        allMapper.insertCommunication(communication);

    }

    @Override
    public void addMessage(Message message) {

        allMapper.addMessage(message);

    }

    @Override
    public List<Message> selectMessageId(int currentPage, int pageSize, int sender_id) {

        //        调用方法
        List<Message> rows = allMapper.selectMessageId(currentPage,pageSize);

        return rows;

    }

    @Override
    public void insertCourse(Course course) {

        allMapper.insertCourse(course);

    }

    @Override
    public List<Course> selectCourse(int num) {

        List<Course> courses = allMapper.selectCourse(num);

        return courses;

    }


}
