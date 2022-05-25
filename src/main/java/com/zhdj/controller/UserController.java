package com.zhdj.controller;
import com.alibaba.fastjson.JSONObject;
import com.zhdj.bean.*;
import com.zhdj.bean.Collections;
import org.apache.commons.io.FileUtils;
import com.alibaba.fastjson.JSON;
import com.zhdj.service.AllServlet;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Resource
    private AllServlet userServlet;
    private Collections collections1;

    @RequestMapping("/login")
    public void login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----login");
        Integer result=200;

//        2.使用mybatis完成查询
        User user = userServlet.selectUser(username,password);

        JSONObject res = new JSONObject();
        res.put("data",userServlet.selectByUsername(username));
        res.put("result",200);

        System.out.println(user);
        //response响应字符数据
//        response.setContentType("text/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (user!=null) {
//        获取字符输出流到前端
            response.getWriter().print(res);
            //登陆成功
//            writer.write("登陆成功");
        }else {
            writer.write("登陆失败");
        }
    }
    @RequestMapping("/user")
    public void user(String id, HttpServletResponse response) throws ServletException, IOException {
//        2.使用mybatis完成查询
        JSONObject res = new JSONObject();
        User user = userServlet.selectById(Integer.parseInt(id));
        res.put("data",user);
        System.out.println(userServlet.selectById(Integer.parseInt(id)));
        res.put("result",200);

//        System.out.println(user);
//        //response响应字符数据
//        String s = JSON.toJSONString(user);
//        System.out.println(s);
//        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(res.toJSONString());

    }
    @RequestMapping("/register")
    public void register(String username,String password,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //        2.使用mybatis完成查询
        User user = userServlet.selectByUsername(username);
        JSONObject jsonObject = new JSONObject();
        int result=200;
        jsonObject.put("data","result");
        jsonObject.put("result",result);

//        判断用户对象是否为null
        if(user==null) {
            User user1 = new User();
            user1.setName(username);
            user1.setPass(password);
            System.out.println(user1);
            userServlet.addUser(user1);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObject);
        }else{
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用户名已存在");
        }
    }

    //暂时废弃
//    @RequestMapping("/addCollection")
//    public void addCollection(@RequestParam("collection_id")String collection_id,@RequestParam("user_id")Integer user_id,@RequestParam("type")Integer type,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        request.setCharacterEncoding("UTF-8");
//
//        Date date = new Date();
//        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//        System.out.println(dateFormat.format(date));
//
//        Collections collection = new Collections(user_id,collection_id,type,dateFormat.format(date));
//
//        collection.setMes("yes!");
//        System.out.println(collection);
//        //        2.使用mybatis完成添加
//        userServlet.addCollection(user_id,collection_id,type);
//        System.out.println("here?");
//        response.setContentType("text/json;charset=utf-8");
//
////        获取字符输出流到前端
//        JSONObject res = new JSONObject();
//        res.put("data",collection);
//        res.put("result",200);
//        response.getWriter().write(res.toJSONString());
//    }

    @RequestMapping("/collection")
    public void collection(Integer user_id,String page1,String page2,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        //1.接受用户名和密码
//        String user_id = request.getParameter("user_id");
//        String _currentPage = request.getParameter("page1");
//        String _pageSize = request.getParameter("page2");

        int currentPage = Integer.parseInt(page1)-1;
        int pageSize = Integer.parseInt(page2);
        System.out.println(user_id);

//        2.使用mybatis完成查询
        List<Collections> collections = userServlet.selectCollectionsId(currentPage, pageSize,user_id);

        System.out.println(collections);
        //response响应字符数据
//        String s = JSON.toJSONString(collections);
//        System.out.println(s);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("",jsonObject.put("data",collections));
        jsonObject.put("result",200);

        response.setContentType("text/json;charset=utf-8");
//        获取字符输出流到前端
        response.getWriter().write(jsonObject.toJSONString());

    }

    @RequestMapping("/updateUsers")
    public void updateUser(String id,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //2.调用service查询
        User users = userServlet.selectById(Integer.parseInt(id));
        //3.储存到request中
        request.setAttribute("users",users);
        //4.转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    @RequestMapping("/updateUser")
    public void updateServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("updateServlet");
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //1. 接收表单提交的数据，封装为一个Brand对象
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String bg_img = request.getParameter("bg_img");



        //封装为一个User对象
        User user = userServlet.selectById(Integer.parseInt(id));
        user.setPass(pass);
        user.setEmail(email);
        user.setSex(sex);
        user.setBg_img(bg_img);


        System.out.println(user);
        //2. 调用service 完成修改
        userServlet.update(user);

        JSONObject res = new JSONObject();
        res.put("data",userServlet.selectById(Integer.parseInt(id)));
        System.out.println(userServlet.selectById(Integer.parseInt(id)));
        res.put("result",200);

        response.getWriter().write(res.toJSONString());

    }


    @RequestMapping(value = "/feedback",produces = "text/plain;charset=utf-8")
    public void insertFeedback(String user_id,String content,String reply,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");


        FeedBack feedBack = new FeedBack();
        feedBack.setUser_id(user_id);

        feedBack.setContent(content);
        feedBack.setReply(reply);
        userServlet.insertFeedback(feedBack);
        System.out.println(feedBack);

        //2.调用service写入

        JSONObject res = new JSONObject();
        res.put("result",200);
        System.out.println(res.toJSONString());
        response.getWriter().write(res.toJSONString());
    }

    @RequestMapping(value = "/sendMessage",produces = "text/plain;charset=utf-8")
        public void addMessage(int uid,int mid,String content,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        System.out.println("sendMessage");

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        System.out.println(dateFormat.format(date));

        String decode = URLEncoder.encode(content, "iso-8859-1");
        System.out.println(decode);
        String encode = URLDecoder.decode(decode, "utf-8");
        System.out.println(encode);

        Message message = new Message();
        message.setUser_id(uid);
        message.setSender_id(mid);
        message.setContent(encode);
        message.setTime(dateFormat.format(date));
        System.out.println(message);
        //        2.使用mybatis完成添加
        userServlet.addMessage(message);

        JSONObject res = new JSONObject();
        res.put("result",200);
        System.out.println(res.toJSONString());
        response.getWriter().write(res.toJSONString());
    }

    @RequestMapping("/message")
    public void selectMessageId(String page1,String page2,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        //1.接受用户名和密码
//        String user_id = request.getParameter("user_id");
//        String _currentPage = request.getParameter("page1");
//        String _pageSize = request.getParameter("page2");
    int mid = 0;
        int currentPage = Integer.parseInt(page1);
        int pageSize = Integer.parseInt(page2);
        System.out.println(mid);

//        2.使用mybatis完成查询
        List<Message> messages = userServlet.selectMessageId(currentPage, pageSize,mid);

        System.out.println(messages);
        //response响应字符数据
        String s = JSON.toJSONString(messages);

        response.setContentType("text/json;charset=utf-8");
//        获取字符输出流到前端
        JSONObject res = new JSONObject();
        res.put("data",messages);
        res.put("result",200);
        System.out.println(res.toJSONString());
        response.getWriter().write(res.toJSONString());
    }


}
