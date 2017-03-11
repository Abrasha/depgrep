package com.github.abrasha.depgrep.service.impl;

import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.persistence.FeedbackRepository;
import com.github.abrasha.depgrep.service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Service
public class ArtifactServiceImpl implements ArtifactService {
    
    private final FeedbackRepository feedbackRepository;
    
    @Autowired
    public ArtifactServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
    
    public Feedback createNewFeedback(String query, String artifactId) {
        Feedback feedback = new Feedback();
        feedback.setTimesApproved(0);
        feedback.setQuery(query);
        feedback.setArtifactId(artifactId);
        return feedback;
    }
    
    @Override
    public Feedback approveQuery(String query, String artifactId) {
        Feedback feedback = feedbackRepository.findOneByArtifactIdAndQuery(artifactId, query);
        
        if (feedback == null) {
            feedback = createNewFeedback(query, artifactId);
        }
        
        feedback.setTimesApproved(feedback.getTimesApproved() + 1);
        feedbackRepository.save(feedback);
        
        return feedback;
    }
    
}
