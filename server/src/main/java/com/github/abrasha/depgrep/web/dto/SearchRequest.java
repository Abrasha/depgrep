package com.github.abrasha.depgrep.web.dto;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class SearchRequest {
    
    private String group;
    private String artifact;
    
    public String getGroup() {
        return group;
    }
    
    public void setGroup(String group) {
        this.group = group;
    }
    
    public String getArtifact() {
        return artifact;
    }
    
    public void setArtifact(String artifact) {
        this.artifact = artifact;
    }
    
    @Override
    public String toString() {
        return "SearchRequest{" +
                "group='" + group + '\'' +
                ", artifact='" + artifact + '\'' +
                '}';
    }
}
