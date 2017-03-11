package com.github.abrasha.depgrep.web.dto;

import com.github.abrasha.depgrep.core.model.Artifact;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class ApproveDto {
    
    private String query;
    private Artifact artifact;
    
    
    public String getQuery() {
        return query;
    }
    
    public void setQuery(String query) {
        this.query = query;
    }
    
    public Artifact getArtifact() {
        return artifact;
    }
    
    public void setArtifact(Artifact artifact) {
        this.artifact = artifact;
    }
    
    @Override
    public String toString() {
        return "ApproveDto{" +
                "query='" + query + '\'' +
                ", artifact=" + artifact +
                '}';
    }
}
