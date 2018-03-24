package com.jk.interceptor;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * 注册拦截器   
 * Created by SYSTEM on 2017/8/16.   
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Bean
    InterceptorConfig interceptorConfig() {
        return new InterceptorConfig();
    }
    @Bean
    PowerConfig powerConfig() {
        return new PowerConfig();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/**");
        registry.addResourceHandler("/WEB-INF/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/WEB-INF/**");
        super.addResourceHandlers(registry);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(powerConfig()).addPathPatterns("/**")  .excludePathPatterns("/error/**")
                .excludePathPatterns("*.js")
                .excludePathPatterns("/login/login.do")
                .excludePathPatterns("/login/getInterfaceSMS")
                //.excludePathPatterns("/js/layui-v2.2.5/layui/layui.js")
                .excludePathPatterns("*.css")
                .excludePathPatterns("/login/userLoginMethod");
        registry.addInterceptor(interceptorConfig()).addPathPatterns("/**")
                .excludePathPatterns("/login/login.do")
                .excludePathPatterns("/login/getInterfaceSMS") .excludePathPatterns("/login/userLoginMethod");
                // .excludePathPatterns("/error/**")
                // .excludePathPatterns("*.js")
               // .excludePathPatterns("/js/layui-v2.2.5/layui/layui.js")
               // .excludePathPatterns("*.css")



    }
}   