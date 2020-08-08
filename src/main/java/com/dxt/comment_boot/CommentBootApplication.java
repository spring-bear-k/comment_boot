package com.dxt.comment_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@ComponentScan("com.dxt.comment_boot")
@MapperScan("com.dxt.comment_boot.mapper")
public class CommentBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CommentBootApplication.class, args);
    }

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CommentBootApplication.class);
    }*/


}
