package com.zhdj.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhdj.bean.*;
import com.zhdj.service.AllService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/redclass")
public class CommunicationController {

    @Resource
    private AllService communicatServlet;

    @RequestMapping("/books")
    public void insertBooks(@RequestBody Book book, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //2.调用service查询
        communicatServlet.insertBook(book);
        //3.储存到request中
        String s = JSON.toJSONString(book);
        response.setContentType("text/json;charset=utf-8");
        System.out.println(s);

        response.getWriter().write(s);

    }

    @RequestMapping("/book")
    public void selectBook(String page1,String page2, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int currentPage = Integer.parseInt(page1)-1;
        int pageSize = Integer.parseInt(page2);

        //2.调用service查询
        List<Book> books = communicatServlet.selectBook(currentPage, pageSize);
        //3.储存到request中
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",books);
        jsonObject.put("result",200);
        response.getWriter().write(jsonObject.toJSONString());

    }

//    心声
    @RequestMapping("/addDeliver")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public void insertDynamic(int user_id,String content, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题

        request.setCharacterEncoding("utf-8");

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        System.out.println(dateFormat.format(date));
        //        中文转码

        String contents = URLEncoder.encode(content, "iso-8859-1");
        String contentss = URLDecoder.decode(contents, "utf-8");

        Communication communication = new Communication();
        communication.setUser_id(user_id);
        communication.setContent(contentss);
        communication.setTime(dateFormat.format(date));
        System.out.println(communication);

        //2.调用service写入
        communicatServlet.insertCommunication(communication);

        JSONObject res = new JSONObject();
        res.put("result",200);
        System.out.println(res.toJSONString());
        response.getWriter().write(res.toJSONString());

    }

    @RequestMapping("/addMetting")
    public void addMetting(String name,String number,String man,String link,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        System.out.println(dateFormat.format(date));
        //        中文转码
        String names = URLEncoder.encode(name, "iso-8859-1");
        String numbers = URLEncoder.encode(number, "iso-8859-1");
        String mans = URLEncoder.encode(man, "iso-8859-1");
        String links = URLEncoder.encode(link, "iso-8859-1");
        String namess = URLDecoder.decode(names, "utf-8");
        String numberss = URLDecoder.decode(numbers, "utf-8");
        String manss = URLDecoder.decode(mans, "utf-8");
        String linkss = URLDecoder.decode(links, "utf-8");

        Course course = new Course(namess,numberss,manss,linkss,dateFormat.format(date));

        System.out.println(course);

        //2.调用service写入
        communicatServlet.insertCourse(course);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",200);
        response.getWriter().write(jsonObject.toJSONString());

    }


    @RequestMapping("/metting")
    public void selectMetting(String page1/*String name,String number,String man,String link*/,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
//
//        Date date = new Date();
//        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//        System.out.println(dateFormat.format(date));
//        //        中文转码
//        String contents = URLEncoder.encode(name, "iso-8859-1");
//        String numbers = URLEncoder.encode(number, "iso-8859-1");
//        String mans = URLEncoder.encode(man, "iso-8859-1");
//        String links = URLEncoder.encode(link, "iso-8859-1");
//        String contentss = URLDecoder.decode(contents, "utf-8");
//        String numberss = URLDecoder.decode(numbers, "utf-8");
//        String manss = URLDecoder.decode(mans, "utf-8");
//        String linkss = URLDecoder.decode(links, "utf-8");
//
//        Course course = new Course(contentss,numberss,manss,linkss,dateFormat.format(date));
//
//        System.out.println(course);
//
//        //2.调用service写入
//        communicatServlet.insertCourse(course);


        List<Course> courses = communicatServlet.selectCourse(Integer.parseInt(page1));
        String s = JSON.toJSONString(courses);
//        转换成json格式
//        response.setContentType("text/json;charset=utf-8");
        System.out.println(s);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",courses);
        jsonObject.put("result",200);
        response.getWriter().write(jsonObject.toJSONString());

    }



}
