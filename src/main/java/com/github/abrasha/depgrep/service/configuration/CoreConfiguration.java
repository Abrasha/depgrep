package com.github.abrasha.depgrep.service.configuration;

import com.github.abrasha.depgrep.service.MavenRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Configuration
public class CoreConfiguration {
    
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new MavenRequestInterceptor()));
        return restTemplate;
    }
    
}
