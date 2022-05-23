package com.zhdj.controller;


import com.alibaba.fastjson.JSONObject;
import com.zhdj.bean.Aspirations;
import com.zhdj.service.HearthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class AspirationsController {

    @Autowired
    HearthService hearthService;
    @GetMapping("/redclass/checks")
    public String YouSoulYouBeat(@RequestParam("page1") int page1,@RequestParam("page2") int page2){
        List<Aspirations> aspirations = hearthService.YouSoulYouBeat(page1, page2);
        JSONObject res = new JSONObject();
        if (aspirations == null) {
            res.put("data","");
            res.put("result",400);
            return res.toJSONString();
        }

        res.put("data",aspirations);
        res.put("result",200);
        return res.toJSONString();
    }
    @GetMapping("/redclass/deliver")
    public String MYSoulMyBeat(@RequestParam("page1") int page1,@RequestParam("page2") int page2,@RequestParam("user_id") int user_id){
        List<Aspirations> aspirations = hearthService.MySoulMyBeat(page1,page2,user_id);
        JSONObject res = new JSONObject();
        if (aspirations == null) {
            res.put("data","");
            res.put("result",400);
            return res.toJSONString();
        }
        res.put("data",aspirations);
        res.put("result",200);
        return res.toJSONString();
    }
    @PostMapping(value = "/redclass/addDeliver",produces = "text/plain;charset=utf-8")
    public String addAspirations(@RequestParam("user_id") int user_id,@RequestParam("content") String content){
        JSONObject res = new JSONObject();
        if (hearthService.addMyWish(content,new Date(),user_id) == 0) {
            res.put("data","");
            res.put("result",400);
            return res.toJSONString();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", " 鉴定为寄");
        res.put("data", jsonObject);
        res.put("result",200);
        return res.toJSONString();
    }

}
