package com.dai7.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Cruise
 * @Date 2016-06-14-15:43
 */
public class LoginAuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(LoginAuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
//        if (userInfo == null){
//            logger.info("用户未登录...");
//            response.sendRedirect("/index");
//            return false;
//        }else {
//            return true;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }


}
