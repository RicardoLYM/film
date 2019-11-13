package com.example.film;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//如果需要使用注释进行SQL语句绑定 指定扫描 mapper包下的接口
@MapperScan("com.example.film.mapper")
@SpringBootApplication
public class FilmApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmApplication.class, args);
    }

}
