package com.github.abrasha.depgrep.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
