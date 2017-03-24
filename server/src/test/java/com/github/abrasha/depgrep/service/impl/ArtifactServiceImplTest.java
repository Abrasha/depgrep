package com.github.abrasha.depgrep.service.impl;

import com.github.abrasha.depgrep.AbstractApplicationTest;
import com.github.abrasha.depgrep.core.model.Artifact;
import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.service.ArtifactProvider;
import com.github.abrasha.depgrep.service.ArtifactService;
import com.github.abrasha.depgrep.service.FeedbackResolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static org.hamcrest.Matchers.*;

/**
 * @author Andrii Abramov on 3/24/17.
 */
public class ArtifactServiceImplTest extends AbstractApplicationTest {

    private static final String GROUP_NAME = "com.google.inject";
    private static final String ARTIFACT_NAME = "guice";
    private static final String QUERY = "query";
    private static final Integer TIMES_APPROVED = 1;

    @MockBean
    private ArtifactProvider<Artifact> artifactProvider;

    @MockBean
    private FeedbackResolver feedbackResolver;

    @Autowired
    private ArtifactService artifactService;

    private Artifact artifact;

    @Before
    public void setUp() {
        artifact = getArtifact();
        when(feedbackResolver.getFeedbackForArtifact(artifact.getArtifactId())).thenReturn(getFeedback());
    }


    @Test
    public void findByGroupName() throws Exception {
        when(artifactProvider.findByGroup(GROUP_NAME)).thenReturn(singletonList(artifact));

        List<Artifact> response = artifactService.findByGroupName(GROUP_NAME);

        assertCorrectLikesAssigned(response);
    }

    private void assertCorrectLikesAssigned(List<Artifact> response) {
        assertThat(response, is(not(empty())));
        assertThat(response, hasSize(1));

        Artifact resultArtifact = response.get(0);
        assertThat(resultArtifact.getLikes(), equalTo(TIMES_APPROVED));
        assertThat(resultArtifact.getArtifactId(), equalTo(artifact.getArtifactId()));
    }

    @Test
    public void findByArtifactName() throws Exception {
        when(artifactProvider.findByArtifactName(ARTIFACT_NAME)).thenReturn(singletonList(artifact));

        List<Artifact> response = artifactService.findByArtifactName(ARTIFACT_NAME);

        assertCorrectLikesAssigned(response);
    }

    @Test
    public void findByGroupAndArtifact() throws Exception {
        when(artifactProvider.findByGroupAndArtifact(GROUP_NAME, ARTIFACT_NAME)).thenReturn(singletonList(artifact));

        List<Artifact> response = artifactService.findByGroupAndArtifact(GROUP_NAME, ARTIFACT_NAME);

        assertCorrectLikesAssigned(response);
    }

    @Test
    public void findByQuery() throws Exception {
        when(artifactProvider.findByQuery(QUERY)).thenReturn(singletonList(artifact));

        List<Artifact> response = artifactService.findByQuery(QUERY);

        assertCorrectLikesAssigned(response);
    }

    private Artifact getArtifact() {
        Artifact artifact = new Artifact();
        artifact.setGroup(GROUP_NAME);
        artifact.setArtifact(ARTIFACT_NAME);
        return artifact;
    }

    private Feedback getFeedback() {
        Feedback feedback = new Feedback();
        feedback.setArtifactId(ARTIFACT_NAME);
        feedback.setTimesApproved(TIMES_APPROVED);
        return feedback;
    }


}