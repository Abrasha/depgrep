package com.github.abrasha.depgrep.service.impl;

import com.github.abrasha.depgrep.core.model.Artifact;
import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.service.ArtifactProvider;
import com.github.abrasha.depgrep.service.ArtifactService;
import com.github.abrasha.depgrep.service.FeedbackResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrii Abramov on 3/22/17.
 */
@Service
public class ArtifactServiceImpl implements ArtifactService {
    
    private final ArtifactProvider<Artifact> artifactProvider;
    private final FeedbackResolver feedbackResolver;
    
    @Autowired
    public ArtifactServiceImpl(ArtifactProvider<Artifact> artifactProvider, FeedbackResolver feedbackResolver) {
        this.artifactProvider = artifactProvider;
        this.feedbackResolver = feedbackResolver;
    }
    
    @Override
    public List<Artifact> findByGroupName(String group) {
        List<Artifact> artifacts = artifactProvider.findByGroup(group);
        return resolveLikes(artifacts);
    }
    
    @Override
    public List<Artifact> findByArtifactName(String artifactName) {
        List<Artifact> artifacts = artifactProvider.findByArtifactName(artifactName);
        return resolveLikes(artifacts);
    }
    
    @Override
    public List<Artifact> findByGroupAndArtifact(String group, String artifactName) {
        List<Artifact> artifacts = artifactProvider.findByGroupAndArtifact(group, artifactName);
        return resolveLikes(artifacts);
    }
    
    @Override
    public List<Artifact> findByQuery(String query) {
        List<Artifact> artifacts = artifactProvider.findByQuery(query);
        return resolveLikes(artifacts);
    }
    
    private List<Artifact> resolveLikes(List<Artifact> artifacts) {
        return artifacts.stream()
                .peek(artifact -> {
                    Feedback feedback = feedbackResolver.getFeedbackForArtifact(artifact.getArtifactId());
                    artifact.setLikes(feedback.getTimesApproved());
                })
                .collect(Collectors.toList());
    }
    
}
