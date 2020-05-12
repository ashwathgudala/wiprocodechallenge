package com.wipro.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com")
@SpringBootApplication
public class JsonParserApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonParserApplication.class, args);
    }

}

