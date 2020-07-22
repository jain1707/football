package com.example.football.config;

import com.example.football.service.FootballService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(FootballService.class);
    }
}
