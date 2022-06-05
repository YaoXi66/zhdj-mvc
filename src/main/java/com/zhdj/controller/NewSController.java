package com.zhdj.controller;


import com.alibaba.fastjson.JSONObject;
import com.zhdj.bean.Dynamic;
import com.zhdj.service.AllService;
import com.zhdj.service.NewsService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;

@RestController
public class NewSController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @Resource
    private AllService communicatServlet;
    public String GetNewsHanderError(int type ,int page1,int page2){
        JSONObject res = new JSONObject();
        try{
            res.put("data",newsService.SelectDynamicList(type,page1,page2));
            System.out.println(newsService.SelectDynamicList(type,page1,page2));
            res.put("result",200);
        }
        catch (Exception e){
            res.put("data","总之！你错了");
            res.put("result",400);
            return res.toJSONString();
        }
        return res.toJSONString();
    }

    @GetMapping(value = "/news/affairs",produces = "text/plain;charset=utf-8")
    public String GetAffairs(@RequestParam("page1")int page1,@RequestParam("page2")int page2){
        return GetNewsHanderError(0,page1,page2);
    }
    @GetMapping(value = "/news/dynamic",produces = "text/plain;charset=utf-8")
    public String GetDynamic(@RequestParam("page1")int page1,@RequestParam("page2")int page2){
        return GetNewsHanderError(1,page1,page2);
    }
    @GetMapping(value = "/news/policy",produces = "text/plain;charset=utf-8")
    public String GetPolicy(@RequestParam("page1")int page1,@RequestParam("page2")int page2){
        return GetNewsHanderError(2,page1,page2);
    }
    @GetMapping(value = "/news/pioneer",produces = "text/plain;charset=utf-8")
    public String GetPioneer(@RequestParam("page1")int page1,@RequestParam("page2")int page2){
        return GetNewsHanderError(3,page1,page2);
    }
    @PostMapping(value = "/news/release",produces = "text/plain;charset=utf-8")
    public String PostRelease(@RequestParam("user_id") int user_id, @RequestParam("id") int id, @RequestParam("time") String time, @RequestParam("link") String link, @RequestParam("type") String type, @RequestParam("title") String title, @RequestParam("preview") String preview){
        JSONObject res = new JSONObject();
        JSONObject msg = new JSONObject();
        try{
            newsService.addDynamicList(user_id, id, time, link,  type, title, preview);
        }
        catch (Exception e){
            msg.put("msg","ERROR");
            res.put("data",msg);
            res.put("result",400);
            return res.toJSONString();
        }

        msg.put("msg","OK");
        res.put("data",msg);
        res.put("result",200);
        return res.toJSONString();
    }

    @PostMapping(value = "/users/addCollection",produces = "text/plain;charset=utf-8")
    public String addCollect(@RequestParam("collection_id")Integer collection_id,@RequestParam("user_id")int user_id,@RequestParam("user_id")int type){

        JSONObject res = new JSONObject();
        JSONObject msg = new JSONObject();
        try {


            Dynamic dynamic = newsService.selectDynamicById(collection_id);
            System.out.println(dynamic);
            System.out.println("user id"+user_id);
            newsService.addCollect(user_id,dynamic.getId(),dynamic.getTime(),dynamic.getType(),dynamic.getTitle(),dynamic.getPreview());

        }
        catch (Exception e)
        {
            msg.put("mes","SO SAD");
            res.put("data",msg);
            res.put("result",400);
            return res.toJSONString();
        }

        msg.put("mes","OK");
        res.put("data",msg);
        res.put("result",200);
        return res.toJSONString();
    }

    @SneakyThrows
    @PostMapping(value = "/users/HeadUpload",produces = "text/plain;charset=utf-8")
    public String upload(@RequestParam("file") MultipartFile data,@RequestParam("user_id")int user_id){
        JSONObject res = new JSONObject();
//        try {
        ByteArrayInputStream inputStream = (ByteArrayInputStream )data.getInputStream();
        byte[]arr = new byte[1280000];
        inputStream.read(arr);
        String fileName = "D:\\暂时\\ideaIC-2022.1.1.win\\zhdj-mvc\\" + user_id + ".jpg";//这边是你的文件路劲
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(arr);
        fileOutputStream.close();

        newsService.updateHead(fileName,user_id);

        JSONObject msg = new JSONObject();
        msg.put("meg",data.getName());
        res.put("data",msg);
        res.put("result",400);
        return res.toJSONString();
//        } catch (IOException e) {
//
//            res.put("data","ERROR");
//            res.put("result",400);
//            return res.toJSONString();
//        }

    }

//    @GetMapping(value = "/redclass/book",produces = "text/plain;charset=utf-8")
//    public String GetBook(){
//        JSONObject res = new JSONObject();
//
//
//        communicatServlet.
//        res.put("data","总之！你错了");
//        res.put("result",400);
//        return res.toJSONString();
//    }
    @GetMapping(value = "/redclass/vrlist",produces = "text/plain;charset=utf-8")
    public String GetVrlist(@RequestParam("page1")Integer page1,@RequestParam("page2")Integer page2){
        JSONObject res = new JSONObject();
        res.put("data",newsService.SelectVrlist(page1, page2));
        res.put("result",200);
        return res.toJSONString();
    }
    @GetMapping(value = "/redclass/exam",produces = "text/plain;charset=utf-8")
    public String GetExam(@RequestParam("page1")Integer page1,@RequestParam("page2")Integer page2){
        JSONObject res = new JSONObject();
        res.put("data",newsService.SelectEXamlist(page1, page2));
        res.put("result",200);
        return res.toJSONString();
    }
}
