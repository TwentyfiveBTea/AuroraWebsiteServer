package com.btea.config.security;

import com.btea.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 17:10
 * @Description: 拦截器
 */
public class AuthInterceptor implements HandlerInterceptor {
//    @Autowired
//    private AuthService authService;

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        Object loginUser = session.getAttribute("loginUser");
//        // 判断是否存在 session
//        return loginUser != null;
//    }
}
