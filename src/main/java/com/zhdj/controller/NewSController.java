package com.zhdj.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhdj.bean.Dynamic;
import com.zhdj.service.AllServlet;
import com.zhdj.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class NewSController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/news/affairs")
    public String GetAffairs(@RequestParam("page1")int page1,@RequestParam("page2")int page2){
        JSONObject res = new JSONObject();
        res.put("data",newsService.SelectDynamicList(0,page1,page2));
        res.put("result",200);
        return res.toJSONString();
    }
    @GetMapping("/news/dynamic")
    public String GetDynamic(@RequestParam("page1")int page1,@RequestParam("page2")int page2){
        JSONObject res = new JSONObject();
        res.put("data",newsService.SelectDynamicList(1,page1,page2));
        res.put("result",200);
        return res.toJSONString();
    }
    @GetMapping("/news/policy")
    public String GetPolicy(@RequestParam("page1")int page1,@RequestParam("page2")int page2){
        JSONObject res = new JSONObject();
        res.put("data",newsService.SelectDynamicList(2,page1,page2));
        res.put("result",200);
        return res.toJSONString();
    }
    @GetMapping("/news/pioneer")
    public String GetPioneer(@RequestParam("page1")int page1,@RequestParam("page2")int page2){
        JSONObject res = new JSONObject();
        res.put("data",newsService.SelectDynamicList(3,page1,page2));
        res.put("result",200);
        return res.toJSONString();
    }

}
