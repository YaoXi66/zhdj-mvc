package com.zhdj.mappers;

import com.zhdj.bean.Aspirations;
import com.zhdj.bean.Dynamic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface HearthMapper {
    @Select(" select * from `heartfeltwishes` limit #{page1}, #{page2};")
    List<Aspirations> YouSoulYouBeat(@Param("page1") int page1, @Param("page2") int page2);

    @Select(" select * from `heartfeltwishes` where user_id = #{user_id} limit #{page1}, #{page2};")
    List<Aspirations> MySoulMyBeat(@Param("page1") int page1, @Param("page2") int page2,@Param("user_id")int user_id);

   @Insert("INSERT INTO `heartfeltwishes` (`content`, `time`, `user_id`) VALUES (#{content},#{time},#{user_id})")
    int addMyWish(@Param("content") String content, @Param("time") Date time, @Param("user_id") int user_id);
}
