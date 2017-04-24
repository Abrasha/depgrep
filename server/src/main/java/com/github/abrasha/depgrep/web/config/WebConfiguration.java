package com.github.abrasha.depgrep.web.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
}
