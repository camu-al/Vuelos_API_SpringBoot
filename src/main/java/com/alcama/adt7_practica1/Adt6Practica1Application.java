package com.alcama.adt7_practica1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Adt6Practica1Application extends SpringBootServletInitializer {

    // Clase principal no se modifica
    public static void main(String[] args) {
        SpringApplication.run(Adt6Practica1Application.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(Adt6Practica1Application.class);
    }

}
