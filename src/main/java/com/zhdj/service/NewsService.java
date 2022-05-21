package com.zhdj.service;

import com.zhdj.bean.Dynamic;
import org.springframework.stereotype.Service;

import java.util.List;


public interface NewsService {
    List<Dynamic> SelectDynamicList(int type,int page1,int page2);
}
