package com.zhdj.service;




import com.zhdj.bean.*;

import java.util.List;

public interface AllService {
    /**
     * 查询动态表所有
     * @return
     */
    List<Dynamic> selectDynamic(int currentPage, int pageSize,int type);
//
    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 查询动用户表所有
     * @return
     */
    User selectUser(String name, String pass);
    /**
     * 查询动用户名
     * @return
     */
    User selectByUsername(String name);

    /**
     * 查询用户id
     * @param id
     * @return
     */
    User selectById(int id);

    /**
     * 添加收藏
     * @param collection
     */
    void addCollection(Collections collection);

    /**
     * 查询用户收藏
     * @param user_id
     * @return
     */
    List<Collections> selectCollectionsId(int currentPage, int pageSize, int user_id);

    /**
     * 修改
     */
    void update(User user);


    void updateUserImg(User user);

    void insertFeedback(FeedBack feedBack);

    void insertBook(Book book);

    List<Book> selectBook(int begin,int size);

    void insertDynamic(Dynamic dynamic);

    void insertCommunication(Communication communication);

    void addMessage(Message message);

    List<Message> selectMessageId(int currentPage, int pageSize, int sender_id);

    void insertCourse(Course course);

    List<Course> selectCourse(int num);

}
