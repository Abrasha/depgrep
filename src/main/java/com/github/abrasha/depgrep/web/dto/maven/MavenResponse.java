package com.github.abrasha.depgrep.web.dto.maven;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class MavenResponse {
    
    @JsonProperty("numFound")
    private Integer numberFound;
    
    @JsonProperty("start")
    private Integer offset;
    
    @JsonProperty("docs")
    private List<MavenArtifact> artifacts;
    
    public Integer getNumberFound() {
        return numberFound;
    }
    
    public void setNumberFound(Integer numberFound) {
        this.numberFound = numberFound;
    }
    
    public Integer getOffset() {
        return offset;
    }
    
    public void setOffset(Integer offset) {
        this.offset = offset;
    }
    
    public List<MavenArtifact> getArtifacts() {
        return artifacts;
    }
    
    public void setArtifacts(List<MavenArtifact> artifacts) {
        this.artifacts = artifacts;
    }
}
