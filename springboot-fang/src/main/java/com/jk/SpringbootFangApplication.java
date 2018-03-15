package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
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
