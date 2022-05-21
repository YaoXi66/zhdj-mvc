package com.zhdj.controller;

import com.alibaba.fastjson.JSON;
import com.zhdj.bean.Book;
import com.zhdj.bean.Course;
import com.zhdj.bean.Dynamic;
import com.zhdj.bean.Message;
import com.zhdj.service.AllServlet;
import com.zhdj.service.impl.ServletImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/news1")
public class DynamicController{

    @Resource
    private AllServlet dynamicServlet;

    public void all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        List<Dynamic> dynamics = dynamicServlet.selectDynamic(Integer.parseInt(currentPage),Integer.parseInt(pageSize),Integer.parseInt(type));

        String s = JSON.toJSONString(dynamics);

        response.setContentType("text/json;charset=utf-8");
//        获取字符输出流到前端
        response.getWriter().write(s);
    }
    @RequestMapping("/affaris")
    public void affaris(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        all(request,response);
    }
    @RequestMapping("/dynamic")
    public void dynamic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        all(request,response);
    }
    @RequestMapping("/policy")
    public void policy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        all(request,response);
    }
    @RequestMapping("/pioneer")
    public void pioneer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        all(request,response);
    }
    @RequestMapping("/text")
    public void text(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        all(request,response);
    }

    @RequestMapping("/release")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public void insertDynamic(int user_id,String content,String type, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题

        request.setCharacterEncoding("utf-8");

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        System.out.println(dateFormat.format(date));
        //        中文转码
        String contents = URLEncoder.encode(content, "iso-8859-1");
        String types = URLEncoder.encode(type, "iso-8859-1");
        String contentss = URLDecoder.decode(contents, "utf-8");
        String typess = URLDecoder.decode(types, "utf-8");

        Dynamic dynamic = new Dynamic();
        dynamic.setUser_id(user_id);
        dynamic.setContent(contentss);
        dynamic.setType(typess);
        dynamic.setTime(dateFormat.format(date));
        System.out.println(dynamic);

        //2.调用service写入
        dynamicServlet.insertDynamic(dynamic);

        response.getWriter().write("success");

    }



}