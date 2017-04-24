package com.github.abrasha.depgrep.service;

import com.github.abrasha.depgrep.core.model.Feedback;

import java.util.List;

/**
 * @author Andrii Abramov on 3/12/17.
 */
public interface FeedbackService {
    
    Feedback findOneByArtifactId(String artifactId);
    
    Feedback save(Feedback feedback);
    
    List<Feedback> getTopUsedArtifacts();
    
    void deleteAll();
}
