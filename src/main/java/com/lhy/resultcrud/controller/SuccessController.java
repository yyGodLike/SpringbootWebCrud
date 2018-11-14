package com.lhy.resultcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
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

}