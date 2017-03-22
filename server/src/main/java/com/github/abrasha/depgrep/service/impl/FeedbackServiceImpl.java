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
    public Feedback findByArtifactId(String artifactId) {
        return feedbackRepository.findOneByArtifactId(artifactId);
    }
    
    @Override
    public Feedback save(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
    
    @Override
    public Feedback approveQuery(String query, String artifactId) {
        Feedback feedback = feedbackRepository.findOneByArtifactIdAndQuery(artifactId, query);
        
        if (feedback == null) {
            feedback = createNewFeedback(query, artifactId);
        }
        
        feedback.setTimesApproved(feedback.getTimesApproved() + 1);
        save(feedback);
        
        return feedback;
    }
    
    private Feedback createNewFeedback(String query, String artifactId) {
        Feedback feedback = new Feedback();
        feedback.setTimesApproved(0);
        feedback.setQuery(query);
        feedback.setArtifactId(artifactId);
        return feedback;
    }
    
}
