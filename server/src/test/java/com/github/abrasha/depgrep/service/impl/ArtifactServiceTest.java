package com.github.abrasha.depgrep.service.impl;

import com.github.abrasha.depgrep.AbstractApplicationTest;
import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.persistence.FeedbackRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author Andrii Abramov on 3/21/17.
 */
public class ArtifactServiceTest extends AbstractApplicationTest {
    
    @Autowired
    private FeedbackRepository feedbackRepository;
    
    @Before
    public void init() {
    }
    
    @Test
    public void approveQuery() throws Exception {
        
    }
    
}