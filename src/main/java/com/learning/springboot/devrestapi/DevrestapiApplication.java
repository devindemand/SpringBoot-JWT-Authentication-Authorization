package com.learning.springboot.devrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//Use component scan to tell spring boot to look into the packages and sub packages defined under this annotation as components
@ComponentScan("com.learning.springboot.devrestapi")
@SpringBootApplication
public class DevrestapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DevrestapiApplication.class, args);
    }
}
