package com.github.abrasha.depgrep.persistence;

import com.github.abrasha.depgrep.AbstractRepositoryTest;
import com.github.abrasha.depgrep.core.model.Feedback;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * @author Andrii Abramov on 3/21/17.
 */
public class FeedbackRepositoryTest extends AbstractRepositoryTest {
    
    private static final String VALID_QUERY = "query";
    private static final String INVALID_VALUE = "invalid";
    private static final String VALID_ARTIFACT_ID = "com.google.inject:guice";
    private static final Integer TIMES_APPROVED = 1;
    
    @Autowired
    private FeedbackRepository feedbackRepository;
    
    @Before
    public void init() {
        Feedback feedback = new Feedback();
        feedback.setQuery(VALID_QUERY);
        feedback.setArtifactId(VALID_ARTIFACT_ID);
        feedback.setTimesApproved(TIMES_APPROVED);
        
        feedbackRepository.save(feedback);
    }
    
    @Test
    public void findByArtifactIdExists() throws Exception {
        List<Feedback> feedback = feedbackRepository.findByArtifactId(VALID_ARTIFACT_ID);
        assertThat(feedback, is(not(empty())));
    }
    
    @Test
    public void findByArtifactIdDoesNotExists() throws Exception {
        List<Feedback> feedback = feedbackRepository.findByArtifactId(INVALID_VALUE);
        assertThat(feedback, is(empty()));
    }
    
    @Test
    public void findOneByArtifactId() throws Exception {
        Feedback feedbacks = feedbackRepository.findOneByArtifactId(VALID_ARTIFACT_ID);
        assertNotNull(feedbacks);
        assertNotNull(feedbacks.getId());
        assertEquals(feedbacks.getArtifactId(), VALID_ARTIFACT_ID);
    }
    
    @Test
    public void findOneByArtifactIdDoesNotExist() throws Exception {
        Feedback feedbacks = feedbackRepository.findOneByArtifactId(INVALID_VALUE);
        assertNull(feedbacks);
    }
    
    @Test
    public void findOneByArtifactIdAndQuery() throws Exception {
        Feedback feedback = feedbackRepository.findOneByArtifactIdAndQuery(VALID_ARTIFACT_ID, VALID_QUERY);
        assertNotNull(feedback);
        assertNotNull(feedback.getId());
        assertEquals(feedback.getArtifactId(), VALID_ARTIFACT_ID);
        assertEquals(feedback.getQuery(), VALID_QUERY);
        assertEquals(feedback.getTimesApproved(), TIMES_APPROVED);
    }
    
    @Test
    public void findOneByArtifactIdAndQueryNoSuchQuery() throws Exception {
        Feedback feedback = feedbackRepository.findOneByArtifactIdAndQuery(VALID_ARTIFACT_ID, INVALID_VALUE);
        assertNull(feedback);
    }
    
    @Test
    public void findOneByArtifactIdAndQueryNoSuchArtifactId() throws Exception {
        Feedback feedback = feedbackRepository.findOneByArtifactIdAndQuery(INVALID_VALUE, VALID_QUERY);
        assertNull(feedback);
    }
    
}