package com.btea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.btea.mapper")
@SpringBootApplication
public class AuroraWebsiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuroraWebsiteApplication.class, args);
    }

}
