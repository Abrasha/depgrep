package com.github.abrasha.depgrep.core.model;

import org.springframework.stereotype.Component;

/**
 * @author Andrii Abramov on 3/21/17.
 */
@Component
public class FeedbackGenerator {
    
    public static class Valid {
        public static final String QUERY = "query";
        public static final String ARTIFACT_ID = "com.google.inject:guice";
        public static final Integer TIMES_APPROVED = 1;
    }
    
    public static class Invalid {
        public static final String QUERY = "invalid";
        public static final String ARTIFACT_ID = "com.group.invalid";
        public static final Integer TIMES_APPROVED = -1;
    }
    
    public Feedback getValidFeedback() {
        Feedback feedback = new Feedback();
        feedback.setQuery(Valid.QUERY);
        feedback.setId(1L);
        feedback.setArtifactId(Valid.ARTIFACT_ID);
        feedback.setTimesApproved(Valid.TIMES_APPROVED);
        return feedback;
    }
    
    public Feedback getInvalidFeedback() {
        Feedback feedback = new Feedback();
        feedback.setQuery(Invalid.QUERY);
        feedback.setArtifactId(Invalid.ARTIFACT_ID);
        feedback.setTimesApproved(Invalid.TIMES_APPROVED);
        return feedback;
    }
    
}
