package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
//@ServletComponentScan注解的作用配置druid必须加的注解，如果不加，访问页面打不开，
// filter和servlet、listener之类的需要单独进行注册才能使用，
// spring boot里面提供了该注解起到注册作用
@MapperScan("com.jk.mapper")
public class SpringbootFangApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootFangApplication.class, args);
	}
	/**
	 * 支持jsp需要重写此方法
	 * @param builder
	 * @return
	 */
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
}
