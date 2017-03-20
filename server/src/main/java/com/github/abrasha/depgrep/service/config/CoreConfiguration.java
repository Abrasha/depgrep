package com.github.abrasha.depgrep.service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Configuration
public class CoreConfiguration {
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
}
