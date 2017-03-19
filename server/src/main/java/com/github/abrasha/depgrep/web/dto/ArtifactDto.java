package com.github.abrasha.depgrep.web.dto;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class ArtifactDto {
    
    private String groupId;
    private String artifactId;
    private String version;
    
    private Integer likes;
    
    public String getGroupId() {
        return groupId;
    }
    
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    public String getArtifactId() {
        return artifactId;
    }
    
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
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
    
    @Override
    public String toString() {
        return "ArtifactDto{" +
                "groupId='" + groupId + '\'' +
                ", artifactId='" + artifactId + '\'' +
                ", version='" + version + '\'' +
                ", likes=" + likes +
                '}';
    }
}