package com.me.athletosports;
import com.me.athletosports.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = (User) request.getSession().getAttribute("userInfo");
        if (request.getRequestURI().equalsIgnoreCase("/athletosports/login.htm") ||
                (request.getRequestURI().equalsIgnoreCase("/athletosports/signup.htm") ||
                        (user != null))) {
            System.out.println("Allowing URL: " + request.getRequestURI());
            return true;
        }
        System.out.println("Intercepting URL: " + request.getRequestURI());
        response.sendRedirect("/athletosports/login.htm");
        return false;
    }

}
