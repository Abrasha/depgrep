package com.github.abrasha.depgrep.web.dto.maven;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Data
public class MavenResponse {
    
    @JsonProperty("numFound")
    private Integer numberFound;
    
    @JsonProperty("start")
    private Integer offset;
    
    @JsonProperty("docs")
    private List<MavenArtifact> artifacts;
    
    @Override
    public String toString() {
        return "MavenResponse{" +
                "numberFound=" + numberFound +
                ", offset=" + offset +
                ", artifacts=" + artifacts +
                '}';
    }
}
