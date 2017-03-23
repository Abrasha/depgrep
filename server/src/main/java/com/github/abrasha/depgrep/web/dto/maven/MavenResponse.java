package com.github.abrasha.depgrep.web.dto.maven;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Data
@Getter(AccessLevel.PUBLIC)
public class MavenResponse {
    
    @JsonProperty("numFound")
    private Integer numberFound;
    
    @JsonProperty("start")
    private Integer offset;
    
    @JsonProperty("docs")
    private List<MavenArtifact> artifacts;
    
}
