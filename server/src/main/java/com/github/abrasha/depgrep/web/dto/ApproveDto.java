package com.github.abrasha.depgrep.web.dto;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class ApproveDto {
    
    private String query;
    private String artifactId;
    
    
    public String getQuery() {
        return query;
    }
    
    public void setQuery(String query) {
        this.query = query;
    }
    
    public String getArtifactId() {
        return artifactId;
    }
    
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }
    
    @Override
    public String toString() {
        return "ApproveDto{" +
                "query='" + query + '\'' +
                ", artifactId='" + artifactId + '\'' +
                '}';
    }
}
