package com.github.abrasha.depgrep.service;

import com.github.abrasha.depgrep.web.dto.maven.MavenCentralSearchResponse;
import com.github.abrasha.depgrep.web.request.ArtifactSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Component
public class MavenCentral {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MavenCentral.class);
    
    @Value("${search.maven.baseurl}")
    private String baseUrl;
    
    private final RestTemplate restTemplate;
    
    @Autowired
    public MavenCentral(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public MavenCentralSearchResponse query(ArtifactSpecification specification) {
        
        String url = getQueryUrl(specification);
        
        MavenCentralSearchResponse searchResponse = restTemplate.getForEntity(url, MavenCentralSearchResponse.class).getBody();
        
        LOGGER.info("got response: {}", searchResponse);
        
        return searchResponse;
    }
    
    private String getQueryUrl(ArtifactSpecification specification) {
        String url = baseUrl + "&q=" + specification.getQuery();
        LOGGER.info("constructed ur: {}", url);
        return url;
    }
    
    
}
