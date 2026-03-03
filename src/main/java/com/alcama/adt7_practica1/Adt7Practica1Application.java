package com.alcama.adt7_practica1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Adt7Practica1Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Adt7Practica1Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Adt7Practica1Application.class, args);
    }
}