package com.veliona.elemebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.veliona.elemebackend.mapper")
public class ElemebackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElemebackendApplication.class, args);
    }

}
