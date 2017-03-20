package com.github.abrasha.depgrep.service.maven;

import com.github.abrasha.depgrep.core.model.Artifact;
import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.service.ArtifactProvider;
import com.github.abrasha.depgrep.service.FeedbackService;
import com.github.abrasha.depgrep.service.specification.*;
import com.github.abrasha.depgrep.web.dto.maven.MavenArtifact;
import com.github.abrasha.depgrep.web.dto.maven.MavenCentralSearchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Service
public class MavenCentralArtifactProvider implements ArtifactProvider<Artifact> {
    
    private static final Logger LOG = LoggerFactory.getLogger(MavenCentralArtifactProvider.class);
    
    private final MavenCentral mavenCentral;
    private final FeedbackService feedbackService;
    
    @Autowired
    public MavenCentralArtifactProvider(MavenCentral mavenCentral, FeedbackService feedbackService) {
        this.mavenCentral = mavenCentral;
        this.feedbackService = feedbackService;
    }
    
    
    @Override
    public List<Artifact> findByArtifactName(String artifactName) {
        return executeRequest(new FindByArtifactSpecification(artifactName));
    }
    
    @Override
    public List<Artifact> findByGroupName(String groupName) {
        return executeRequest(new FindByGroupSpecification(groupName));
    }
    
    @Override
    public List<Artifact> findByQuery(String query) {
        return executeRequest(new FindByQuerySpecification(query));
    }
    
    @Override
    public List<Artifact> findByGroupAndArtifact(String group, String artifact) {
        return executeRequest(new FindByGroupAndArtifactSpecification(group, artifact));
    }
    
    private List<Artifact> executeRequest(ArtifactSpecification specification) {
        MavenCentralSearchResponse response = mavenCentral.query(specification);
        
        return response.getResponse().getArtifacts()
                .stream()
                .map(artifact -> parseResponse(artifact, specification.getQuery()))
                .collect(Collectors.toList());
    }
    
    private Artifact parseResponse(MavenArtifact mavenArtifact, String query) {
        Artifact artifact = new Artifact();
        artifact.setArtifact(mavenArtifact.getArtifactId());
        artifact.setGroup(mavenArtifact.getGroupId());
        artifact.setVersion(mavenArtifact.getLatestVersion());
        
        String artifactId = artifact.getArtifactId();
        Feedback feedback = feedbackService.findByArtifactId(artifactId);
        LOG.debug("found feedback for artifact id = {}: {}", feedback);
        
        if (feedback == null) {
            feedback = new Feedback();
            feedback.setArtifactId(artifactId);
            // initial likes count
            feedback.setTimesApproved(0);
            feedback.setQuery(query);
            Feedback saved = feedbackService.save(feedback);
            LOG.debug("Saved new feedback: {}", saved);
        } else {
            artifact.setLikes(feedback.getTimesApproved());
        }
        
        
        return artifact;
    }
    
}
