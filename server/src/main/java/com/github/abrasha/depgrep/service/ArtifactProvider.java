package com.github.abrasha.depgrep.service;

import com.github.abrasha.depgrep.core.model.Artifact;

import java.util.List;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public interface ArtifactProvider<T extends Artifact> {
    
    List<T> findByArtifactName(String artifactName);
    
    List<T> findByGroup(String group);
    
    List<T> findByGroupAndArtifact(String group, String artifact);
    
    List<T> findByQuery(String query);
    
}
