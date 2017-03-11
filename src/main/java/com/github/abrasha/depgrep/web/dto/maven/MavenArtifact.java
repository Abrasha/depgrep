package com.github.abrasha.depgrep.web.dto.maven;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class MavenArtifact {
    
    private String id;
    
    @JsonProperty("g")
    private String groupId;
    
    @JsonProperty("a")
    private String artifactId;
    
    private String latestVersion;
    private String repositoryId;
    
    private String p;
    private Long timestamp;
    private Integer versionCount;
    private List<String> text;
    private List<String> ec;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
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
    
    public String getLatestVersion() {
        return latestVersion;
    }
    
    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }
    
    public String getRepositoryId() {
        return repositoryId;
    }
    
    public void setRepositoryId(String repositoryId) {
        this.repositoryId = repositoryId;
    }
    
    public String getP() {
        return p;
    }
    
    public void setP(String p) {
        this.p = p;
    }
    
    public Long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    
    public Integer getVersionCount() {
        return versionCount;
    }
    
    public void setVersionCount(Integer versionCount) {
        this.versionCount = versionCount;
    }
    
    public List<String> getText() {
        return text;
    }
    
    public void setText(List<String> text) {
        this.text = text;
    }
    
    public List<String> getEc() {
        return ec;
    }
    
    public void setEc(List<String> ec) {
        this.ec = ec;
    }
    
    @Override
    public String toString() {
        return "MavenArtifact{" +
                "id='" + id + '\'' +
                ", groupId='" + groupId + '\'' +
                ", artifactId='" + artifactId + '\'' +
                ", latestVersion='" + latestVersion + '\'' +
                ", repositoryId='" + repositoryId + '\'' +
                ", p='" + p + '\'' +
                ", timestamp=" + timestamp +
                ", versionCount=" + versionCount +
                ", text=" + text +
                ", ec=" + ec +
                '}';
    }
}