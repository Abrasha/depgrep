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
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * @author Andrii Abramov on 3/21/17.
 */
public class FeedbackRepositoryTest extends AbstractRepositoryTest {
    
    @Autowired
    private FeedbackRepository feedbackRepository;
    
    @Autowired
    private FeedbackGenerator feedbackGenerator;
    
    private Feedback saved;
    
    @Before
    public void init() {
        feedbackRepository.deleteAll();
        saved = feedbackRepository.save(feedbackGenerator.getValidFeedback());
    }
    
    @Test
    public void findAllExists() throws Exception {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        assertThat(feedbacks.size(), is(1));
    }
    
    @Test
    public void findByIdExists() throws Exception {
        Optional<Feedback> feedback = feedbackRepository.findById(saved.getId());
        assertTrue(feedback.isPresent());
        assertThat(feedback.get().getId(), is(not(nullValue())));
    }
    
    @Test
    public void findByIdDoesNotExist() throws Exception {
        Optional<Feedback> feedback = feedbackRepository.findById(0L);
        assertFalse(feedback.isPresent());
    }
    
    @Test
    public void deleteOne() throws Exception {
        feedbackRepository.deleteById(saved.getId());
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
        int count = 5;
        List<Feedback> feedbacks = getSomeFeedbacks(count);
        
        feedbackRepository.saveAll(feedbacks);
        
        assertThat(feedbackRepository.findAll(), hasSize(count));
    }
    
    @Test
    public void findAllByArtifactIdExists() throws Exception {
        List<Feedback> feedback = feedbackRepository.findAllByArtifactId(Valid.ARTIFACT_ID);
        assertThat(feedback, is(not(empty())));
    }
    
    @Test
    public void findAllByArtifactIdDoesNotExists() throws Exception {
        List<Feedback> feedback = feedbackRepository.findAllByArtifactId(Invalid.ARTIFACT_ID);
        assertThat(feedback, is(empty()));
    }
    
    @Test
    public void findByIdByArtifactIdExists() throws Exception {
        Feedback feedback = feedbackRepository.findOneByArtifactId(Valid.ARTIFACT_ID);
        assertThat(feedback, is(not(nullValue())));
        assertThat(feedback.getId(), is(not(nullValue())));
        assertThat(feedback.getArtifactId(), is(Valid.ARTIFACT_ID));
    }
    
    @Test
    public void findByIdByArtifactIdDoesNotExist() throws Exception {
        Feedback feedback = feedbackRepository.findOneByArtifactId(Invalid.ARTIFACT_ID);
        assertThat(feedback, is(nullValue()));
    }
    
    
    private List<Feedback> getSomeFeedbacks(int count) {
        return IntStream.range(1, count).mapToObj(num -> {
            Feedback feedback = new Feedback();
            feedback.setArtifactId("artifact:id" + num);
            return feedback;
        }).collect(Collectors.toList());
    }
    
}