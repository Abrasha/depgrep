package com.github.abrasha.depgrep.service.maven;

import com.github.abrasha.depgrep.web.dto.maven.MavenCentralSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author Andrii Abramov on 3/23/17.
 */
@Component
public class MavenCentralExecutor {
    
    private final RestTemplate restTemplate;
    
    @Autowired
    public MavenCentralExecutor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public MavenCentralSearchResponse executeRequest(URI uri) {
        return restTemplate.getForEntity(uri, MavenCentralSearchResponse.class).getBody();
    }
    
}
