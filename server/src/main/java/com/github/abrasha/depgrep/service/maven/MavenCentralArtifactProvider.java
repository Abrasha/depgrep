package com.github.abrasha.depgrep.service.maven;

import com.github.abrasha.depgrep.core.model.Artifact;
import com.github.abrasha.depgrep.service.ArtifactProvider;
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
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MavenCentralArtifactProvider.class);
    
    private final MavenCentral mavenCentral;
    
    @Autowired
    public MavenCentralArtifactProvider(MavenCentral mavenCentral) {
        this.mavenCentral = mavenCentral;
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
                .map(this::parseResponse)
                .collect(Collectors.toList());
    }
    
    private Artifact parseResponse(MavenArtifact mavenArtifact) {
        Artifact artifact = new Artifact();
        artifact.setArtifact(mavenArtifact.getArtifactId());
        artifact.setGroup(mavenArtifact.getGroupId());
        artifact.setVersion(mavenArtifact.getLatestVersion());
        artifact.setLikes(123);
        return artifact;
    }
    
}
