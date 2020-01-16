package com.ljt.springboot.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 定义登录拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser != null){
            //已经登录 ，放行
            return true;
        }
        //没有登录
        request.setAttribute("msg","没有登录，请先登录！");
        request.getRequestDispatcher("/index.html").forward(request,response);
        return false;
    }
}
