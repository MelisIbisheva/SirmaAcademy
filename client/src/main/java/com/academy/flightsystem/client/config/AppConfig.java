package com.academy.flightsystem.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    // send Rest request to backend
    @Bean
    public RestTemplate restTemplate (){
        return new RestTemplate();
    }
}
