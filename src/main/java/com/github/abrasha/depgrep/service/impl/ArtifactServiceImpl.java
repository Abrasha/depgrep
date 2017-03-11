package com.github.abrasha.depgrep.service.impl;

import com.github.abrasha.depgrep.core.model.Artifact;
import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.persistence.ArtifactRepository;
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
    private final ArtifactRepository artifactRepository;
    
    @Autowired
    public ArtifactServiceImpl(ArtifactRepository artifactRepository, FeedbackRepository feedbackRepository) {
        this.artifactRepository = artifactRepository;
        this.feedbackRepository = feedbackRepository;
    }
    
    public Feedback createNewFeedback(String query, Artifact artifact) {
        Feedback feedback = new Feedback();
        feedback.setTimesApproved(0);
        feedback.setQuery(query);
        feedback.setArtifact(artifact);
        return feedback;
    }
    
    @Override
    public Artifact approveQuery(String query, Artifact artifact) {
        Feedback feedback = feedbackRepository.findOneByQueryAndArtifactArtifactId(query, artifact.getArtifactId());
        
        if (feedback == null) {
            feedback = createNewFeedback(query, artifact);
        }
        
        feedback.setTimesApproved(feedback.getTimesApproved() + 1);
        feedbackRepository.save(feedback);
        
        Artifact result = artifactRepository.findOne(artifact.getId());
        
        result.setLikes(result.getLikes() + 1);
        
        return artifactRepository.save(artifact);
    }
    
}
