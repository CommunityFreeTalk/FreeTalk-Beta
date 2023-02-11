package com.example.freetalk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@MapperScan(value={"com.example.freetalk.mapper"})
public class FreeTalkApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeTalkApplication.class, args);
    }

}
