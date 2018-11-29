package com.lhy.resultcrud.expiation;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Springmvc异常处理器类
 */
@ControllerAdvice
public class MyExceptionHandler {


    /**
     * 处理user相关的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(UserException.class)
    public String handleUserException(Exception e, HttpServletRequest request) {

        //一定要传入错误状态码，4xx或5xx，提供给DefaultErrorViewResolver解析，否则不会进入定制的异常页面的解析流程。
        request.setAttribute("javax.servlet.error.status_code", 500);

        Map map = new HashMap();
        map.put("code", "userNotExist");
        map.put("message", e.getMessage());

        //将异常处理方法要返回给前端的异常信息放入request域中。
        // 方便自定义的getErrorAttributes方法获取一并返回给前端。
        request.setAttribute("ext", map);
        //转发到/error,通过BasicErrorController处理，自适应处理结果返回。
        return "forward:/error";
    }
}
