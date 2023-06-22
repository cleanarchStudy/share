package com.example.adpexamplebanservice.authorizer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class Permissions implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod && ((HandlerMethod) handler).hasMethodAnnotation(NotRequiredLoginCheck.class)) {
            return true;
        }

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
            throw new RuntimeException(); // Member못찾는 예외로
        }

        if (handler instanceof HandlerMethod && ((HandlerMethod) handler).hasMethodAnnotation(Accessible.class)) {
            String role = handler.class.getAnnotation(Accessible.class).role();

            return true;
        }







        return true;
    }
}
