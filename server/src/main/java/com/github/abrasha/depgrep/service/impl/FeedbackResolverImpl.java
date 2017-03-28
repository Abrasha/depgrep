package com.github.abrasha.depgrep.service.impl;

import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.service.FeedbackResolver;
import com.github.abrasha.depgrep.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Andrii Abramov on 3/20/17.
 */
@Component
public class FeedbackResolverImpl implements FeedbackResolver {
    
    private final FeedbackService feedbackRepository;
    
    @Autowired
    public FeedbackResolverImpl(FeedbackService feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
    
    @Override
    public Feedback getFeedbackForArtifact(String artifactId) {
        Feedback feedback = feedbackRepository.findOneByArtifactId(artifactId);
        
        if (feedback == null) {
            feedback = feedbackRepository.save(createDefaultFeedback(artifactId));
        }
        
        return feedback;
    }
    
    @Override
    public Feedback likeArtifact(String artifactId) {
        Feedback feedback = getFeedbackForArtifact(artifactId);
        
        feedback.setTimesApproved(feedback.getTimesApproved() + 1);
        
        return feedbackRepository.save(feedback);
    }
    
    private Feedback createDefaultFeedback(String artifactId) {
        Feedback feedback = new Feedback();
        feedback.setArtifactId(artifactId);
        feedback.setTimesApproved(0);
        return feedback;
    }
    
}
