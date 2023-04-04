package org.omotcha;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.omotcha.mappers")
public class OmotChainDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(OmotChainDataApplication.class, args);
    }
}
