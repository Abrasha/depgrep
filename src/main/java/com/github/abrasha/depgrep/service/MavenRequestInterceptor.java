package com.github.abrasha.depgrep.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class MavenRequestInterceptor implements ClientHttpRequestInterceptor {
    
    private static final Logger log = LoggerFactory.getLogger(MavenRequestInterceptor.class);
    
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        
        traceRequest(request);
        ClientHttpResponse response = execution.execute(request, body);
        traceResponse(response);
        
        return response;
    }
    
    private void traceRequest(HttpRequest request) {
        log.debug("Performing request: {}", request.getURI());
    }
    
    private void traceResponse(ClientHttpResponse response) {
        try {
            log.debug("Got response: {}", response.getStatusText());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
}
