package com.github.abrasha.depgrep.web.controller.rest;

import com.github.abrasha.depgrep.AbstractApplicationTest;
import com.github.abrasha.depgrep.Application;
import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.service.FeedbackService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;

/**
 * @author Andrii Abramov on 3/20/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@MockBeans({
        @MockBean(classes = FeedbackService.class)
})
@ContextConfiguration(classes = Application.class)
public class FeedbackControllerTest extends AbstractApplicationTest {
    
    @Autowired
    private FeedbackService feedbackService;
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    private MockMvc mockMvc;
    
    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }
    
    @Test
    @Ignore("Test is broken. Setup should be more maintained")
    public void approveArtifact() throws Exception {
        String artifactId = "group:artifact";
        
        Feedback feedback = new Feedback();
        feedback.setArtifactId(artifactId);
        feedback.setTimesApproved(10);
        feedback.setQuery("query");
        
        when(feedbackService.findByArtifactId(artifactId))
                .thenReturn(feedback);
        
        mockMvc.perform(MockMvcRequestBuilders.get("localhost:8080/?q=guice"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        
    }
    
}