package com.zhdj.mappers;




import com.zhdj.bean.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AllMapper {

    List<Dynamic> selectDynamic(@Param("begin") int begin,@Param("size") int size,int type);

    User selectUser(@Param("name") String username, @Param("pass") String password);

    @Insert("insert into user(name, pass, email, sex, bg_img, header_img)  " +
            "values " +
            "(#{name},#{pass},#{email},#{sex},#{bg_img},#{header_img})")
    void addUser(User user);

    @Select("select*from user where name=#{name}")
    User selectByUsername(String name);

    @Select("select * from user where id=#{id}")
    User selectById(int id);

    @Insert("insert into collection(user_id, collection_id,type)  " +
            "values " +
            "(#{user_id},#{collection_id},#{type})")
    void addCollection(Collections collection);


    List<Collections> selectCollectionsId(@Param("begin") int begin,@Param("size") int size,@Param("user_id")int user_id);

    //修改
    void update(User user);

    void updateUserImg(User user);
    @Insert("INSERT INTO feedback VALUES (#{user_id},#{content},#{reply})")
    void insertFeedback(FeedBack feedBack);

    @Insert("INSERT INTO book (title, author, introduce,img_src) VALUES (#{title},#{author},#{introduce},#{img_src})")
    void insertBook(Book book);

    void selectBook(@Param("begin") int begin,@Param("size") int size);

    @Insert("INSERT INTO dynamic (user_id,time, content, type) VALUES (#{user_id},#{time},#{content},#{type})")
    void insertDynamic(Dynamic dynamic);

    @Insert("INSERT INTO communication (user_id,time, content) VALUES (#{user_id},#{time},#{content})")
    void insertCommunication(Communication communication);

    @Insert("insert into message(user_id, sender_id,content,time)  " +
            "values " +
            "(#{user_id},#{sender_id},#{content},#{time})")
//    @ResultMap("messageResultMap")
    void addMessage(Message message);

    List<Message> selectMessageId(@Param("begin") int begin,@Param("size") int size,@Param("sender_id")int sender_id);

    @Insert("insert into course(name,number,man,link,time)  " +
            "values " +
            "(#{name},#{number},#{man},#{link},#{time})")
    void insertCourse(Course course);

    @Select("select * from course order by id asc limit #{num}")
    List<Course> selectCourse(int num);



}
