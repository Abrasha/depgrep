package com.github.abrasha.depgrep.service;

import com.github.abrasha.depgrep.core.model.Feedback;

/**
 * @author Andrii Abramov on 3/12/17.
 */
public interface ArtifactService {
    
    Feedback approveQuery(String query, String artifactId);
    
}