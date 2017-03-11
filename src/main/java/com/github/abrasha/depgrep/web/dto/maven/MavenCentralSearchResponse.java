package com.github.abrasha.depgrep.web.dto.maven;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class MavenCentralSearchResponse {
    
    private MavenResponseHeader responseHeader;
    private MavenResponse response;
    
    public MavenResponseHeader getResponseHeader() {
        return responseHeader;
    }
    
    public void setResponseHeader(MavenResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }
    
    public MavenResponse getResponse() {
        return response;
    }
    
    public void setResponse(MavenResponse response) {
        this.response = response;
    }
    
    @Override
    public String toString() {
        return "MavenCentralSearchResponse{" +
                "responseHeader=" + responseHeader +
                ", response=" + response +
                '}';
    }
}
