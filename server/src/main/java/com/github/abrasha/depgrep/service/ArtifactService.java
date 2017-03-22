package com.github.abrasha.depgrep.service;

import com.github.abrasha.depgrep.core.model.Artifact;

import java.util.List;

/**
 * @author Andrii Abramov on 3/12/17.
 */
public interface ArtifactService {
    
    List<Artifact> findByGroupName(String group);
    
    List<Artifact> findByArtifactName(String artifactName);
    
    List<Artifact> findByGroupAndArtifact(String group, String artifactName);
    
    List<Artifact> findByQuery(String query);
    
}
