package com.github.abrasha.depgrep.service;

import com.github.abrasha.depgrep.core.model.Feedback;

/**
 * @author Andrii Abramov on 3/20/17.
 */
public interface FeedbackResolver {
    
    Feedback getFeedbackForArtifact(String artifactId, String query);
    
}
