package com.jk.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * 注册拦截器   
 * Created by SYSTEM on 2017/8/16.   
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor((HandlerInterceptor) new InterceptorConfig()).addPathPatterns("/*/**").excludePathPatterns("/login/login.do","/login/getInterfaceSMS","/login/userLoginMethod");
    }
}   