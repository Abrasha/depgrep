package com.github.abrasha.depgrep.service.impl;

import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.persistence.FeedbackRepository;
import com.github.abrasha.depgrep.service.FeedbackResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Andrii Abramov on 3/20/17.
 */
@Component
public class FeedbackResolverImpl implements FeedbackResolver {
    
    private final FeedbackRepository feedbackRepository;
    
    @Autowired
    public FeedbackResolverImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
    
    @Override
    public Feedback getFeedbackForArtifact(String artifactId, String query) {
        Feedback feedback = feedbackRepository.findOneByArtifactIdAndQuery(artifactId, query);
        
        if (feedback == null) {
            feedback = new Feedback();
            feedback.setArtifactId(artifactId);
            feedback.setTimesApproved(0);
            feedback.setQuery(query);
        }
        
        return feedbackRepository.save(feedback);
    }
}
