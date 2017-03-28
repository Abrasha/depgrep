package com.github.abrasha.depgrep.service.impl;

import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.persistence.FeedbackRepository;
import com.github.abrasha.depgrep.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Abramov on 3/20/17.
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {
    
    private final FeedbackRepository feedbackRepository;
    
    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
    
    @Override
    public Feedback findOneByArtifactId(String artifactId) {
        return feedbackRepository.findOneByArtifactId(artifactId);
    }
    
    @Override
    public Feedback save(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
    
    @Override
    public void deleteAll() {
        feedbackRepository.deleteAll();
    }
    
}
