package com.mxy.booksharing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mxy.booksharing.dao")
public class BookSharingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookSharingApplication.class, args);
        System.out.println("********************系统启动成功***********************************!");
    }
}
