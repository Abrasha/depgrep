package com.github.abrasha.depgrep.web.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.abrasha.depgrep.AbstractApplicationTest;
import com.github.abrasha.depgrep.core.model.ArtifactGenerator.Invalid;
import com.github.abrasha.depgrep.core.model.ArtifactGenerator.Valid;
import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.service.FeedbackService;
import com.github.abrasha.depgrep.web.dto.FeedbackDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Andrii Abramov on 3/25/17.
 */
@WebAppConfiguration
public class FeedbackControllerTest extends AbstractApplicationTest {
    
    @Autowired
    private WebApplicationContext context;
    
    private final ObjectMapper mapper = new ObjectMapper();
    
    private MockMvc mockMvc;
    
    private static final String LOCALHOST = "http://localhost:8080";
    
    @Autowired
    private FeedbackService feedbackService;
    
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        
        Feedback feedback = new Feedback();
        feedback.setArtifactId(Valid.ARTIFACT_ID);
        feedback.setTimesApproved(1);
        feedbackService.save(feedback);
        
    }
    
    @After
    public void tearDown() throws Exception {
        feedbackService.deleteAll();
    }
    
    @Test
    public void approveArtifactExistsNoFeedback() throws Exception {
        MockHttpServletRequestBuilder request = getApproveRequest("junit:junit");
        
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(assertValidApprovedTimesResponse(1));
    }
    
    @Test
    public void approveArtifactExistsWithFeedback() throws Exception {
        MockHttpServletRequestBuilder request = getApproveRequest(Valid.ARTIFACT_ID);
        
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(assertValidApprovedTimesResponse(2));
    }
    
    @Test
    public void approveArtifactDoesNotExist() throws Exception {
        MockHttpServletRequestBuilder request = getApproveRequest(Invalid.ARTIFACT_ID);
        
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(assertValidApprovedTimesResponse(1));
    }
    
    private MockHttpServletRequestBuilder getApproveRequest(String artifact) {
        return MockMvcRequestBuilders.request(HttpMethod.POST, getApproveUrl(artifact))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
    }
    
    private ResultMatcher assertValidApprovedTimesResponse(int timesApproved) {
        return mvcResult -> {
            FeedbackDto response = parseApproveResponse(mvcResult);
            assertThat(response, is(notNullValue()));
            assertThat(response.getTimesApproved(), equalTo(timesApproved));
        };
    }
    
    private String getApproveUrl(String artifact) {
        return LOCALHOST + "/approve/" + artifact;
    }
    
    private FeedbackDto parseApproveResponse(MvcResult mvcResult) throws IOException {
        return mapper.readValue(mvcResult.getResponse().getContentAsString(), FeedbackDto.class);
    }
    
}