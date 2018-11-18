package com.lhy.resultcrud.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {


    /**
     * 在执行action方法执行该方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        //获取登陆成功存放的session值，若为空则需要跳转登陆界面重新登陆，否则直接执行action方法。
        Object user = httpServletRequest.getSession().getAttribute("userName");
        if(user == null){
            httpServletRequest.setAttribute("errorMsg","没有权限访问，请登录系统");
            httpServletRequest.getRequestDispatcher("/login.html").forward(httpServletRequest,httpServletResponse);
            //httpServletResponse.sendRedirect("crud/login.html");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
