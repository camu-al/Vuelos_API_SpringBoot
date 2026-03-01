package com.alcama.adt7_practica1.util;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VueloConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Vuelos API")
                        .description("Vuelos API adt7")
                        .contact(new Contact()
                                .name("Alex Camuñas Martínez")
                                .email("alecammar2@alu.edu.gva.es")
                                .url("https://ieslluissimarro.org/"))
                        .version("1.0"));
    }

}