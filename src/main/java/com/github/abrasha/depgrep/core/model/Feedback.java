package com.github.abrasha.depgrep.core.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Entity
public class Feedback extends BaseEntity {
    
    private String query;
    private Integer timesApproved;
    
    @ManyToOne
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
                ", artifact=" + artifact +
                "} " + super.toString();
    }
}