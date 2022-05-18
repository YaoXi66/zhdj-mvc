package com.zhdj.controller;
import com.zhdj.bean.*;
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
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Resource
    private AllServlet userServlet;

    @RequestMapping("/login")
    public void login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----login");
        Integer result=200;

//        2.使用mybatis完成查询
        User user = userServlet.selectUser(username,password);

        System.out.println(user);
        //response响应字符数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        if (user!=null) {

//        获取字符输出流到前端
            response.getWriter().print(result);
            //登陆成功
//            writer.write("登陆成功");
        }else {
            writer.write("登陆失败");
        }
    }
    @RequestMapping("/user")
    public void user(String id, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(id);

//        2.使用mybatis完成查询
        User user = userServlet.selectById(Integer.parseInt(id));

        System.out.println(user);
        //response响应字符数据
        String s = JSON.toJSONString(user);

        response.setContentType("text/json;charset=utf-8");
//        获取字符输出流到前端
        response.getWriter().write(s);

    }
    @RequestMapping("/register")
    public void register(String username,String password,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //        2.使用mybatis完成查询
        User user = userServlet.selectByUsername(username);

//        判断用户对象是否为null
        if(user==null) {
            User user1 = new User();
            user1.setName(username);
            user1.setPass(password);
            System.out.println(user1);
            userServlet.addUser(user1);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(200);
        }else{
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用户名已存在");
        }
    }
    @RequestMapping("/addCollection")
    public void addCollection(String user_id,String collection_id,String type,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

//        String user_id = request.getParameter("user_id");
//        String collection_id = request.getParameter("collection_id");
//        String type = request.getParameter("type");
//        中文转码
        String decode = URLEncoder.encode(type, "iso-8859-1");
        System.out.println(decode);
        String encode = URLDecoder.decode(decode, "utf-8");
        System.out.println(encode);

        Collections collection = new Collections(Integer.parseInt(user_id),Integer.parseInt(collection_id),encode);
        System.out.println(collection);
        //        2.使用mybatis完成添加
        userServlet.addCollection(collection);

//        response.setContentType("text/json;charset=utf-8");
//        获取字符输出流到前端
        response.getWriter().write("success");
    }

    @RequestMapping("/collection")
    public void collection(String user_id,String page1,String page2,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        //1.接受用户名和密码
//        String user_id = request.getParameter("user_id");
//        String _currentPage = request.getParameter("page1");
//        String _pageSize = request.getParameter("page2");

        int currentPage = Integer.parseInt(page1)-1;
        int pageSize = Integer.parseInt(page2);
        System.out.println(user_id);

//        2.使用mybatis完成查询
        List<Collections> collections = userServlet.selectCollectionsId(currentPage, pageSize,Integer.parseInt(user_id));

        System.out.println(collections);
        //response响应字符数据
        String s = JSON.toJSONString(collections);

        response.setContentType("text/json;charset=utf-8");
//        获取字符输出流到前端
        response.getWriter().write(s);

    }

    @RequestMapping("/updateUser")
    public void updateUser(String id,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //2.调用service查询
        User users = userServlet.selectById(Integer.parseInt(id));
        //3.储存到request中
        request.setAttribute("users",users);
        //4.转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    @RequestMapping("/updateServlet")
    public void updateServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("updateServlet");
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //1. 接收表单提交的数据，封装为一个Brand对象
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String bg_img = request.getParameter("bg_img");
        String header_img = request.getParameter("header_img");


        //封装为一个User对象
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setName(name);
        user.setPass(pass);
        user.setEmail(email);
        user.setSex(sex);
        user.setBg_img(bg_img);
        user.setHeader_img(header_img);


        //2. 调用service 完成修改
        userServlet.update(user);
    }

    @RequestMapping("/HeadUpload")
    public void HeadUpload(User user, MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println("------------HeadUpload");
        String id = request.getParameter("id");

//        1..获取图片后缀名，生成新的文件
        String originalFilename = file.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));//.jsp
        System.out.println(ext);
        String fileName=System.currentTimeMillis()+ext;

//        2.获取imgs目录在服务器的路径
        String dir = request.getServletContext().getRealPath("imgs");
        String savePath = dir + "/" + fileName;

//        3.保存文件
        file.transferTo(new File(savePath));

//        4.将图片访问路径设置到user对象
        user.setHeader_img("imgs/"+fileName);
        user.setId(Integer.parseInt(id));

        System.out.println(user);
        System.out.println(user.getHeader_img());
        System.out.println(user.getId());

//        5.调用service保存user到数据库
        userServlet.updateUserImg(user);


    }

    @RequestMapping("/feedback")
    public void insertFeedback(String user_id,String content,String reply,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //        中文转码
        System.out.println(content+"content");
        String decode = URLEncoder.encode(content, "iso-8859-1");
        String decodes = URLEncoder.encode(reply, "iso-8859-1");
        System.out.println(decode+"decode");
        String encode = URLDecoder.decode(decode, "utf-8");
        String encodes = URLDecoder.decode(decodes, "utf-8");


        FeedBack feedBack = new FeedBack();
        feedBack.setUser_id(user_id);

        feedBack.setContent(encode);
        feedBack.setReply(encodes);

        System.out.println(feedBack);

        //2.调用service查询
        userServlet.insertFeedback(feedBack);
    }

    @RequestMapping("/sendMessage")
        public void addMessage(int user_id,int sender_id,String content,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");


        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        System.out.println(dateFormat.format(date));

        String decode = URLEncoder.encode(content, "iso-8859-1");
        System.out.println(decode);
        String encode = URLDecoder.decode(decode, "utf-8");
        System.out.println(encode);

        Message message = new Message(user_id,sender_id,encode,dateFormat.format(date));
        //        2.使用mybatis完成添加
        userServlet.addMessage(message);

//        response.setContentType("text/json;charset=utf-8");
//        获取字符输出流到前端
        response.getWriter().write("success");
    }

    @RequestMapping("/message")
    public void selectMessageId(int sender_id,String page1,String page2,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        //1.接受用户名和密码
//        String user_id = request.getParameter("user_id");
//        String _currentPage = request.getParameter("page1");
//        String _pageSize = request.getParameter("page2");

        int currentPage = Integer.parseInt(page1)-1;
        int pageSize = Integer.parseInt(page2);
        System.out.println(sender_id);

//        2.使用mybatis完成查询
        List<Message> messages = userServlet.selectMessageId(currentPage, pageSize,sender_id);

        System.out.println(messages);
        //response响应字符数据
        String s = JSON.toJSONString(messages);

        response.setContentType("text/json;charset=utf-8");
//        获取字符输出流到前端
        response.getWriter().write(s);

    }


}
