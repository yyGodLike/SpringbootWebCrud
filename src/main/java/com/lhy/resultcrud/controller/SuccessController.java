package com.lhy.resultcrud.controller;

import com.lhy.resultcrud.expiation.UserException;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SuccessController {

    @RequestMapping(value = "helloSuccess")
    public String helloSuccess(Map map){

        map.put("hello" , "欢迎你进入thymeleaf的第一个界面");
        map.put("hello2" , "<h>你好</h3>");
        map.put("names" , Arrays.asList("张三", "李四", "王五"));

        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/tsEroor")
    public Map tsEroor(String name){
        System.out.println("a".equals(name));
        if("a".equals(name)){
            throw new UserException("用户名错误");
        }
        System.out.println(name);
        Map map = new HashMap();
        map.put("info","您好");

        return map;
    }

}