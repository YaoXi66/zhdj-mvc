package com.zhdj.mappers;

import com.zhdj.bean.Dynamic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper {
    @Select(" select * from `dynamic` where `type`=#{type} limit #{page1}, #{page2};")
    List<Dynamic> SelectDynamicList(@Param("type") int type, @Param("page1") int page1, @Param("page2") int page2);
}
