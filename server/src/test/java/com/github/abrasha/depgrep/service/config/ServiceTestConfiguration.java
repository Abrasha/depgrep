package com.github.abrasha.depgrep.service.config;

import com.github.abrasha.depgrep.core.model.FeedbackGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Andrii Abramov on 3/22/17.
 */
@Configuration
public class ServiceTestConfiguration {
    
    @Bean
    public FeedbackGenerator feedbackGenerator(){
        return new FeedbackGenerator();
    }
    
}
