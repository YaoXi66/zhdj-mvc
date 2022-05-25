package com.zhdj.mappers;

import com.zhdj.bean.Dynamic;
import com.zhdj.bean.Vr;
import lombok.Singular;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface NewsMapper {
    @Select(" select * from `dynamic` where `type`=#{type} limit #{page1}, #{page2};")
    List<Dynamic> SelectDynamicList(@Param("type") int type, @Param("page1") int page1, @Param("page2") int page2);

    @Select(" select * from `dynamic` where `id`=#{id}")
    Dynamic selectDynamicById(@Param("id") Integer id);
    @Select(" insert into `collection` (`user_id`, `id`, `time`, `link`, `type`, `title`, `preview`) values (#{user_id}, #{id}, #{time}, #{link}, #{type}, #{title}, #{preview})")
    Integer addDynamicList(@Param("user_id") int user_id,@Param("id") int id,@Param("time") String time,@Param("link") String link,@Param("type") String type,@Param("title") String title,@Param("preview") String preview);

    @Select(" insert into `collection` (`user_id`, `collection_id`, `time`, `type`, `title`, `preview`) values (#{user_id}, #{collection_id}, #{time},#{type}, #{title}, #{preview})")
    Integer addCollect(@Param("user_id") int user_id, @Param("collection_id") Integer collection_id, @Param("time") Date time, @Param("type") Integer type, @Param("title") String title, @Param("preview") String preview);

    @Update("UPDATE `user` SET `header_img` = #{filePath} WHERE `id` = #{id} ")
    Integer updateHead(@Param("filePath")String filePath,@Param("id")int user_id);


    @Select("SELECT * FROM `vrlist` LIMIT #{page1},#{page2}")
    List<Vr>  SelectVrlist(@Param("page1")Integer page1, @Param("page2")Integer page2);


}
