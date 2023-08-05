package com.work.springpro.lesson39;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpringProApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProApplication.class, args);
    }

}
