package com.github.abrasha.depgrep.web.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.LocalHostUriTemplateHandler;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author Andrii Abramov on 3/25/17.
 */
@Configuration
public class WebTestConfiguration {
    
    @Autowired
    private Environment environment;
    
    @Bean
    public TestRestTemplate testRestTemplate(ObjectProvider<RestTemplateBuilder> builderProvider) {
        RestTemplateBuilder builder = builderProvider.getIfAvailable();
        TestRestTemplate template = builder == null ? new TestRestTemplate() : new TestRestTemplate(builder.build());
        template.setUriTemplateHandler(new LocalHostUriTemplateHandler(environment));
        return template;
    }
    
}
