package com.github.abrasha.depgrep.persistence;

import com.github.abrasha.depgrep.AbstractRepositoryTest;
import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.core.model.FeedbackGenerator;
import com.github.abrasha.depgrep.core.model.FeedbackGenerator.Invalid;
import com.github.abrasha.depgrep.core.model.FeedbackGenerator.Valid;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author Andrii Abramov on 3/21/17.
 */
public class FeedbackRepositoryTest extends AbstractRepositoryTest {
    
    @Autowired
    private FeedbackRepository feedbackRepository;
    private Feedback saved;
    
    @Before
    public void init() {
        saved = feedbackRepository.save(FeedbackGenerator.getValidFeedback());
    }
    
    @Test
    public void findAllExists() throws Exception {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        assertThat(feedbacks.size(), is(1));
    }
    
    @Test
    public void findOneExists() throws Exception {
        Feedback feedback = feedbackRepository.findOne(saved.getId());
        assertThat(feedback, is(not(nullValue())));
        assertThat(feedback.getId(), is(not(nullValue())));
    }
    
    @Test
    public void findOneDoesNotExist() throws Exception {
        Feedback feedback = feedbackRepository.findOne(0L);
        assertThat(feedback, is(nullValue()));
    }
    
    @Test
    public void deleteOne() throws Exception {
        feedbackRepository.delete(saved.getId());
        assertThat(feedbackRepository.findAll(), is(empty()));
        
    }
    
    @Test
    public void deleteAll() throws Exception {
        feedbackRepository.deleteAll();
        assertThat(feedbackRepository.findAll(), is(empty()));
    }
    
    @Test
    public void saveOne() throws Exception {
        Feedback feedback = new Feedback();
        feedback.setArtifactId("random:artifact");
        feedbackRepository.save(feedback);
        assertThat(feedbackRepository.findAll(), hasSize(2));
    }
    
    @Test
    public void saveSeveral() throws Exception {
        List<Feedback> feedbacks = IntStream.range(1, 5).mapToObj(num -> {
            Feedback feedback = new Feedback();
            feedback.setArtifactId("artfact:id" + num);
            return feedback;
        }).collect(Collectors.toList());
        
        
        feedbackRepository.save(feedbacks);
        assertThat(feedbackRepository.findAll(), hasSize(5));
    }
    
    @Test
    public void findByArtifactIdExists() throws Exception {
        List<Feedback> feedback = feedbackRepository.findByArtifactId(Valid.ARTIFACT_ID);
        assertThat(feedback, is(not(empty())));
    }
    
    @Test
    public void findByArtifactIdDoesNotExists() throws Exception {
        List<Feedback> feedback = feedbackRepository.findByArtifactId(Valid.QUERY);
        assertThat(feedback, is(empty()));
    }
    
    @Test
    public void findOneByArtifactId() throws Exception {
        Feedback feedbacks = feedbackRepository.findOneByArtifactId(Valid.ARTIFACT_ID);
        assertThat(feedbacks, is(not(nullValue())));
        assertThat(feedbacks.getId(), is(not(nullValue())));
        assertThat(feedbacks.getArtifactId(), is(Valid.ARTIFACT_ID));
    }
    
    @Test
    public void findOneByArtifactIdDoesNotExist() throws Exception {
        Feedback feedbacks = feedbackRepository.findOneByArtifactId(Invalid.ARTIFACT_ID);
        assertThat(feedbacks, is(nullValue()));
    }
    
    @Test
    public void findOneByArtifactIdAndQuery() throws Exception {
        Feedback feedback = feedbackRepository.findOneByArtifactIdAndQuery(Valid.ARTIFACT_ID, Valid.QUERY);
        assertThat(feedback, is(not(nullValue())));
        assertThat(feedback.getId(), is(not(nullValue())));
        
        assertThat(feedback.getArtifactId(), is(Valid.ARTIFACT_ID));
        assertThat(feedback.getQuery(), is(Valid.QUERY));
        assertThat(feedback.getTimesApproved(), is(Valid.TIMES_APPROVED));
    }
    
    @Test
    public void findOneByArtifactIdAndQueryNoSuchQuery() throws Exception {
        Feedback feedback = feedbackRepository.findOneByArtifactIdAndQuery(Valid.ARTIFACT_ID, Invalid.ARTIFACT_ID);
        assertThat(feedback, is(nullValue()));
    }
    
    @Test
    public void findOneByArtifactIdAndQueryNoSuchArtifactId() throws Exception {
        Feedback feedback = feedbackRepository.findOneByArtifactIdAndQuery(Invalid.ARTIFACT_ID, Valid.QUERY);
        assertThat(feedback, is(nullValue()));
    }
    
    @Test
    public void findOneByArtifactIdAndQueryNoSuchArtifact() throws Exception {
        Feedback feedback = feedbackRepository.findOneByArtifactIdAndQuery(Invalid.ARTIFACT_ID, Invalid.QUERY);
        assertThat(feedback, is(nullValue()));
    }
    
}