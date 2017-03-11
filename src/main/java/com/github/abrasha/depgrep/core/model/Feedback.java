package com.github.abrasha.depgrep.core.model;

import javax.persistence.Entity;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Entity
public class Feedback extends BaseEntity {
    
    private String query;
    private Integer timesApproved;
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
    
    public Integer getTimesApproved() {
        return timesApproved;
    }
    
    public void setTimesApproved(Integer timesApproved) {
        this.timesApproved = timesApproved;
    }
    
    @Override
    public String toString() {
        return "Feedback{" +
                "query='" + query + '\'' +
                ", timesApproved=" + timesApproved +
                ", artifact=" + artifactId +
                "} " + super.toString();
    }
}
