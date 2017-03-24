package com.github.abrasha.depgrep.service.impl;

import com.github.abrasha.depgrep.core.model.Artifact;
import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.service.ArtifactProvider;
import com.github.abrasha.depgrep.service.ArtifactService;
import com.github.abrasha.depgrep.service.FeedbackResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrii Abramov on 3/22/17.
 */
@Service
public class ArtifactServiceImpl implements ArtifactService {

    private static final Logger logger = LoggerFactory.getLogger(ArtifactServiceImpl.class);

    private final ArtifactProvider<Artifact> artifactProvider;
    private final FeedbackResolver feedbackResolver;
    
    @Autowired
    public ArtifactServiceImpl(ArtifactProvider<Artifact> artifactProvider, FeedbackResolver feedbackResolver) {
        this.artifactProvider = artifactProvider;
        this.feedbackResolver = feedbackResolver;
    }
    
    @Override
    public List<Artifact> findByGroupName(String group) {
        logger.debug("findByGroupName: {}", group);
        List<Artifact> artifacts = artifactProvider.findByGroup(group);
        logger.debug("findByGroupName - result: {}", artifacts);
        return resolveLikes(artifacts);
    }
    
    @Override
    public List<Artifact> findByArtifactName(String artifactName) {
        logger.debug("findByArtifactName: {}", artifactName);
        List<Artifact> artifacts = artifactProvider.findByArtifactName(artifactName);
        logger.debug("findByArtifactName: {}", artifacts);
        return resolveLikes(artifacts);
    }
    
    @Override
    public List<Artifact> findByGroupAndArtifact(String group, String artifactName) {
        logger.debug("findByGroupAndArtifact: group = {}, artifactName = {}", group, artifactName);
        List<Artifact> artifacts = artifactProvider.findByGroupAndArtifact(group, artifactName);
        logger.debug("findByGroupAndArtifact: {}", artifacts);
        return resolveLikes(artifacts);
    }
    
    @Override
    public List<Artifact> findByQuery(String query) {
        logger.debug("findByQuery: {}", query);
        List<Artifact> artifacts = artifactProvider.findByQuery(query);
        logger.debug("findByQuery: {}", artifacts);
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
