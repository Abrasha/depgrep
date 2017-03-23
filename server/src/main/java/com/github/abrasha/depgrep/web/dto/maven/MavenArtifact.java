package com.github.abrasha.depgrep.web.dto.maven;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Data
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
    
}