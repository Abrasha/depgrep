package com.github.abrasha.depgrep.service.maven;

import com.github.abrasha.depgrep.service.specification.ArtifactSpecification;
import com.github.abrasha.depgrep.web.dto.maven.MavenCentralSearchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Component
public class MavenCentralImpl implements MavenCentral {
    
    private static final Logger LOG = LoggerFactory.getLogger(MavenCentral.class);
    private final RestTemplate restTemplate;
    
    @Value("${search.maven.baseurl}")
    private String baseUrl;
    
    @Autowired
    public MavenCentralImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @Override
    public MavenCentralSearchResponse query(ArtifactSpecification specification) {
        
        URI uri = getQueryUri(specification);
        
        MavenCentralSearchResponse searchResponse = restTemplate.getForEntity(uri, MavenCentralSearchResponse.class).getBody();
        
        LOG.info("got response: {}", searchResponse);
        
        return searchResponse;
    }
    
    private URI getQueryUri(ArtifactSpecification specification) {
        String url = baseUrl + "&q=" + specification.getQuery();
        LOG.info("constructed url: {}", url);
        
        return URI.create(url);
    }
    
    
}
