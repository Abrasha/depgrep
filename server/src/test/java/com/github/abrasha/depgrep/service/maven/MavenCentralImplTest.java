package com.github.abrasha.depgrep.service.maven;

import com.github.abrasha.depgrep.AbstractApplicationTest;
import com.github.abrasha.depgrep.core.model.ArtifactGenerator;
import com.github.abrasha.depgrep.service.specification.ArtifactSpecification;
import com.github.abrasha.depgrep.service.specification.impl.FindByArtifactSpecification;
import com.github.abrasha.depgrep.service.specification.impl.FindByGroupAndArtifactSpecification;
import com.github.abrasha.depgrep.service.specification.impl.FindByGroupSpecification;
import com.github.abrasha.depgrep.web.dto.maven.MavenCentralSearchResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrii Abramov on 3/20/17.
 */
public class MavenCentralImplTest extends AbstractApplicationTest {
    
    private static final String VALID_ARTIFACT = ArtifactGenerator.Valid.ARTIFACT_NAME;
    private static final String VALID_GROUP = ArtifactGenerator.Valid.GROUP;
    
    @Autowired
    private MavenCentral mavenCentral;
    
    @Test
    public void searchByArtifact() throws Exception {
        ArtifactSpecification specification = new FindByArtifactSpecification(VALID_ARTIFACT);
        
        MavenCentralSearchResponse response = mavenCentral.query(specification);
        assertResponseHasArtifacts(response);
        
    }
    
    @Test
    public void searchByGroup() throws Exception {
        ArtifactSpecification specification = new FindByGroupSpecification(VALID_GROUP);
        
        MavenCentralSearchResponse response = mavenCentral.query(specification);
        assertResponseHasArtifacts(response);
    }
    
    @Test
    public void searchByGroupAndArtifact() throws Exception {
        ArtifactSpecification specification = new FindByGroupAndArtifactSpecification(VALID_GROUP, VALID_ARTIFACT);
        
        MavenCentralSearchResponse response = mavenCentral.query(specification);
        assertResponseHasArtifacts(response);
    }
    
    private void assertResponseHasArtifacts(MavenCentralSearchResponse response) {
        assertThat(response, is(notNullValue()));
        assertThat(response.getResponse(), is(notNullValue()));
        assertThat(response.getResponseHeader(), is(notNullValue()));
    
        assertThat(response.getResponse().getArtifacts(), is(not(empty())));
    }
    
}