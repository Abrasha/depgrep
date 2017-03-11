package com.github.abrasha.depgrep.core.model;

import javax.persistence.Entity;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Entity
public class Artifact extends BaseEntity {
    
    private String group;
    private String artifact;
    
    private String version;
    
    private Integer likes;
    
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
    
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    public Integer getLikes() {
        return likes;
    }
    
    public void setLikes(Integer likes) {
        this.likes = likes;
    }
    
    public String getArtifactId() {
        return group + ":" + artifact;
    }
    
    @Override
    public String toString() {
        return "Artifact{" +
                "group='" + group + '\'' +
                ", artifact='" + artifact + '\'' +
                ", version='" + version + '\'' +
                ", likes=" + likes +
                "} " + super.toString();
    }
}
