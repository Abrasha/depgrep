package com.github.abrasha.depgrep.service.maven;

import com.github.abrasha.depgrep.core.model.Artifact;
import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.service.ArtifactProvider;
import com.github.abrasha.depgrep.service.FeedbackResolver;
import com.github.abrasha.depgrep.service.specification.ArtifactSpecification;
import com.github.abrasha.depgrep.service.specification.impl.FindByArtifactSpecification;
import com.github.abrasha.depgrep.service.specification.impl.FindByGroupAndArtifactSpecification;
import com.github.abrasha.depgrep.service.specification.impl.FindByGroupSpecification;
import com.github.abrasha.depgrep.service.specification.impl.FindByQuerySpecification;
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
    private FeedbackResolver feedbackResolver;
    
    @Autowired
    public MavenCentralArtifactProvider(MavenCentral mavenCentral, FeedbackResolver feedbackResolver) {
        this.mavenCentral = mavenCentral;
        this.feedbackResolver = feedbackResolver;
    }
    
    
    @Override
    public List<Artifact> findByArtifactName(String artifactName) {
        return executeRequest(new FindByArtifactSpecification(artifactName));
    }
    
    @Override
    public List<Artifact> findByGroup(String group) {
        return executeRequest(new FindByGroupSpecification(group));
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
        
        return extractArtifacts(response);
    }
    
    private List<Artifact> extractArtifacts(MavenCentralSearchResponse response) {
        return response.getResponse().getArtifacts()
                .stream()
                .map(this::parseArtifact)
                .collect(Collectors.toList());
    }
    
    private Artifact parseArtifact(MavenArtifact mavenArtifact) {
        Artifact artifact = new Artifact();
        artifact.setArtifact(mavenArtifact.getArtifactId());
        artifact.setGroup(mavenArtifact.getGroupId());
        artifact.setVersion(mavenArtifact.getLatestVersion());
        
        String artifactId = artifact.getArtifactId();
        Feedback feedback = feedbackResolver.getFeedbackForArtifact(artifactId);
        
        LOG.debug("found feedback for artifact id = {}: {}", feedback);
        
        artifact.setLikes(feedback.getTimesApproved());
        
        return artifact;
    }
    
}
