package com.github.abrasha.depgrep.web.dto.maven;

import lombok.Data;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Data
public class MavenCentralSearchResponse {
    
    private MavenResponseHeader responseHeader;
    private MavenResponse response;
    
    @Override
    public String toString() {
        return "MavenCentralSearchResponse{" +
                "responseHeader=" + responseHeader +
                ", response=" + response +
                '}';
    }
}
