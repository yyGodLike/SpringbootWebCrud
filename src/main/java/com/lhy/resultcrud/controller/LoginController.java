package com.lhy.resultcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用户控制层
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password, Map map, HttpSession session){

        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            //登陆成功
            //将登陆信息保存到session作用域中，后续可以做很多业务处理
            session.setAttribute("userName", username);
            // 防止F5刷新主界面导致登陆表单重复提交，重定向到主界面
            return "redirect:/main.html";
        }
        map.put("errorMsg","用户名或密码错误");
        return "login";
    }

}
