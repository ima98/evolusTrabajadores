package com.trabajadores.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;



@Configuration
@EnableScheduling
public class AppConfig {

    @Bean
    public TareasPeriodicas task() {
        return new TareasPeriodicas();
    }
    

}