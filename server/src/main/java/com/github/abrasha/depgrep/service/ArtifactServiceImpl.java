package com.github.abrasha.depgrep.service;

import com.github.abrasha.depgrep.core.model.Artifact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Andrii Abramov on 3/22/17.
 */
@Service
public class ArtifactServiceImpl implements ArtifactService {
    
    private final ArtifactProvider<Artifact> artifactProvider;
    
    @Autowired
    public ArtifactServiceImpl(ArtifactProvider<Artifact> artifactProvider) {
        this.artifactProvider = artifactProvider;
    }
    
    @Override
    public List<Artifact> findByGroupName(String group) {
        return artifactProvider.findByGroupName(group);
    }
    
    @Override
    public List<Artifact> findByArtifactName(String artifactName) {
        return artifactProvider.findByArtifactName(artifactName);
    }
    
    @Override
    public List<Artifact> findByGroupAndArtifact(String group, String artifactName) {
        return artifactProvider.findByGroupAndArtifact(group, artifactName);
    }
    
    @Override
    public List<Artifact> findByQuery(String query) {
        return artifactProvider.findByQuery(query);
    }
}
