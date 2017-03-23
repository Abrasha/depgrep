package com.github.abrasha.depgrep.service.maven;

import com.github.abrasha.depgrep.AbstractApplicationTest;
import com.github.abrasha.depgrep.core.model.Artifact;
import com.github.abrasha.depgrep.core.model.ArtifactGenerator;
import com.github.abrasha.depgrep.core.model.ArtifactGenerator.Invalid;
import com.github.abrasha.depgrep.core.model.ArtifactGenerator.Valid;
import com.github.abrasha.depgrep.service.ArtifactProvider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author Andrii Abramov on 3/22/17.
 */
public class MavenCentralArtifactProviderTest extends AbstractApplicationTest {
    
    private static final String VALID_QUERY = "guice";
    private static final String INVALID_QUERY = "i.am.invalid.query";
    
    @Autowired
    private ArtifactProvider<Artifact> artifactProvider;
    
    @Autowired
    private ArtifactGenerator artifactGenerator;
    
    @Test
    public void findByArtifactNameExists() throws Exception {
        List<Artifact> artifacts = artifactProvider.findByArtifactName(Valid.ARTIFACT_NAME);
        assertThat(artifacts, hasSize(greaterThan(0)));
    }
    
    @Test
    public void findByArtifactNameDoesNotExist() throws Exception {
        List<Artifact> artifacts = artifactProvider.findByArtifactName(Invalid.ARTIFACT_NAME);
        assertThat(artifacts, hasSize(equalTo(0)));
    }
    
    @Test
    public void findByGroupNameExists() throws Exception {
        List<Artifact> artifacts = artifactProvider.findByGroup(Valid.GROUP);
        assertThat(artifacts, hasSize(greaterThan(0)));
    }
    
    @Test
    public void findByGroupNameDoesNotExist() throws Exception {
        List<Artifact> artifacts = artifactProvider.findByGroup(Invalid.GROUP);
        assertThat(artifacts, hasSize(equalTo(0)));
    }
    
    @Test
    public void findByQueryExists() throws Exception {
        List<Artifact> artifacts = artifactProvider.findByQuery(VALID_QUERY);
        assertThat(artifacts, hasSize(greaterThan(0)));
    }
    
    @Test
    public void findByQueryDoesNotExist() throws Exception {
        List<Artifact> artifacts = artifactProvider.findByQuery(INVALID_QUERY);
        assertThat(artifacts, hasSize(equalTo(0)));
    }
    
    @Test
    public void findByGroupAndArtifactExists() throws Exception {
        List<Artifact> artifacts = artifactProvider.findByGroupAndArtifact(Valid.GROUP, Valid.ARTIFACT_NAME);
        assertThat(artifacts, hasSize(greaterThan(0)));
    }
    
    @Test
    public void findByGroupAndArtifactDoesNotExist() throws Exception {
        List<Artifact> artifacts = artifactProvider.findByGroupAndArtifact(Invalid.GROUP, Invalid.ARTIFACT_NAME);
        assertThat(artifacts, hasSize(equalTo(0)));
    }
    
}