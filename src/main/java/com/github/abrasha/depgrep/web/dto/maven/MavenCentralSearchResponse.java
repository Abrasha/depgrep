package com.github.abrasha.depgrep.web.dto.maven;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class MavenCentralSearchResponse {
    
    private MavenResponseHeader responseHeader;
    private MavenResponse response;
    
    public MavenResponseHeader getMavenResponseHeader() {
        return responseHeader;
    }
    
    public void setMavenResponseHeader(MavenResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }
    
    public MavenResponse getMavenResponse() {
        return response;
    }
    
    public void setMavenResponse(MavenResponse mavenResponse) {
        this.response = mavenResponse;
    }
}
