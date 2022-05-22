package com.zhdj.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhdj.bean.Dynamic;
import com.zhdj.service.AllServlet;
import com.zhdj.service.NewsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class NewSController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @GetMapping(value = "/news/affairs",produces = "text/plain;charset=utf-8")
    public String GetAffairs(@RequestParam("page1")int page1,@RequestParam("page2")int page2){
        JSONObject res = new JSONObject();
        res.put("data",newsService.SelectDynamicList(0,page1,page2));
        res.put("result",200);
        return res.toJSONString();
    }
    @GetMapping(value = "/news/dynamic",produces = "text/plain;charset=utf-8")
    public String GetDynamic(@RequestParam("page1")int page1,@RequestParam("page2")int page2){
        JSONObject res = new JSONObject();
        res.put("data",newsService.SelectDynamicList(1,page1,page2));
        res.put("result",200);
        return res.toJSONString();
    }
    @GetMapping(value = "/news/policy",produces = "text/plain;charset=utf-8")
    public String GetPolicy(@RequestParam("page1")int page1,@RequestParam("page2")int page2){
        JSONObject res = new JSONObject();
        res.put("data",newsService.SelectDynamicList(2,page1,page2));
        res.put("result",200);
        return res.toJSONString();
    }
    @GetMapping(value = "/news/pioneer",produces = "text/plain;charset=utf-8")
    public String GetPioneer(@RequestParam("page1")int page1,@RequestParam("page2")int page2){
        JSONObject res = new JSONObject();
        res.put("data",newsService.SelectDynamicList(3,page1,page2));
        res.put("result",200);
        return res.toJSONString();
    }
    @PostMapping(value = "/news/release",produces = "text/plain;charset=utf-8")
    public String PostRelease(@RequestParam("user_id") int user_id, @RequestParam("id") int id, @RequestParam("time") String time, @RequestParam("link") String link, @RequestParam("type") String type, @RequestParam("title") String title, @RequestParam("preview") String preview){
        System.out.println(newsService.addDynamicList(user_id, id, time, link,  type, title, preview));
        JSONObject res = new JSONObject();
        JSONObject msg = new JSONObject();
        msg.put("msg","OK");
        res.put("data",msg);
        res.put("result",200);
        return res.toJSONString();
    }



}
