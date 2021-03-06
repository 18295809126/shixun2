package com.jk.interceptor;


import com.jk.model.login.Temp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Configuration
public class InterceptorConfig  implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(InterceptorConfig.class);

    /**
     * 进入controller层之前拦截请求
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        log.info("---------------------开始进入请求地址拦截----------------------------");
        HttpSession session = httpServletRequest.getSession();
        String id = session.getId();//获取session里的key
        Temp emp = (Temp) session.getAttribute(session.getId());//获取用户
        //String requestURI = httpServletRequest.getRequestURI();//获取前台请求的url
        System.out.println(emp.getName());
       // String url2 = null;

        if (!StringUtils.isEmpty(session.getAttribute(id))) {
                return true;
        } else {
            PrintWriter printWriter = httpServletResponse.getWriter();
            httpServletResponse.sendRedirect("../login.jsp");
            printWriter.write("{code:0,message:\"session is invalid,please login again!\"}");
            return false;
        }

    }



    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("---------------视图渲染之后的操作-------------------------0");
    }
}