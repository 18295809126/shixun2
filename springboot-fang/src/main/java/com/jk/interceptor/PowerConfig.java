package com.jk.interceptor;

import com.jk.model.login.Temp;
import com.jk.model.tree.Tree;
import com.jk.service.tree.TreeService;
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
import java.util.List;

@Configuration
public class PowerConfig implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(InterceptorConfig.class);

    @Autowired
    private TreeService treeService;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        log.info("---------------------开始进入请求地址拦截----------------------------");
        HttpSession session = httpServletRequest.getSession();
        String id = session.getId();//获取session里的key
        Temp emp = (Temp) session.getAttribute(session.getId());//获取用户
        String requestURI = httpServletRequest.getRequestURI();//获取前台请求的url
        // System.out.println(emp.getId());
        String url2 = null;
        //System.out.println(url);
        /**/

            List<Tree> url = treeService.geturl(emp.getId());//获取用户的所有权限
            for (int i = 0; i < url.size(); i++) {
                //System.out.println(url);
                url2  += "/"+url.get(i).getHref();

            }
            if (url2.indexOf(requestURI) > -1) {
                return true;
            } else {
                PrintWriter printWriter = httpServletResponse.getWriter();
                httpServletResponse.sendRedirect("../power.jsp");
                return false;
            }

    }




    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
