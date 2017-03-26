package com.github.abrasha.depgrep.web.controller.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.abrasha.depgrep.AbstractApplicationTest;
import com.github.abrasha.depgrep.core.model.ArtifactGenerator;
import com.github.abrasha.depgrep.web.dto.ArtifactDto;
import org.hamcrest.Matcher;
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

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Andrii Abramov on 3/25/17.
 */
@WebAppConfiguration
public class SearchControllerTest extends AbstractApplicationTest {
    
    @Autowired
    private WebApplicationContext context;
    
    private final ObjectMapper mapper = new ObjectMapper();
    
    private MockMvc mockMvc;
    
    private static final String LOCALHOST = "http://localhost:8080";
    
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }
    
    @Test
    public void findByGroupExists() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.GET, getSearchUrl())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .param("group", ArtifactGenerator.Valid.GROUP);
        
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(assertNotEmptyResponse());
    }
    
    @Test
    public void findByGroupDoesNotExist() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.GET, getSearchUrl())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .param("group", ArtifactGenerator.Invalid.GROUP);
        
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(assertEmptyResponse());
    }
    
    @Test
    public void findByArtifactExists() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.GET, getSearchUrl())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .param("artifact", ArtifactGenerator.Valid.ARTIFACT_NAME);
        
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(assertNotEmptyResponse());
    }
    
    @Test
    public void findByArtifactDoesNotExist() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.GET, getSearchUrl())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .param("artifact", ArtifactGenerator.Invalid.ARTIFACT_NAME);
        
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(assertEmptyResponse());
    }
    
    @Test
    public void findByArtifactAndGroupExists() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.GET, getSearchUrl())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .param("group", ArtifactGenerator.Valid.GROUP)
                .param("artifact", ArtifactGenerator.Valid.ARTIFACT_NAME);
        
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(assertNotEmptyResponse());
    }
    
    @Test
    public void findByArtifactAndGroupDoesNotExist() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.GET, getSearchUrl())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .param("group", ArtifactGenerator.Invalid.GROUP)
                .param("artifact", ArtifactGenerator.Invalid.ARTIFACT_NAME);
        
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(assertEmptyResponse());
    }
    
    @Test
    public void findByQueryExists() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.GET, getSearchUrl())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .param("q", "guice");
        
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(assertNotEmptyResponse());
    }
    
    @Test
    public void findByQueryDoesNotExist() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.GET, getSearchUrl())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .param("q", "invalidquerytomavencentral");
        
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(assertEmptyResponse());
    }
    
    private String getSearchUrl() {
        return LOCALHOST + "/search";
    }
    
    private ResultMatcher assertNotEmptyResponse() {
        return assertResponseLength(greaterThan(0));
    }
    
    private ResultMatcher assertEmptyResponse() {
        return assertResponseLength(equalTo(0));
    }
    
    private ResultMatcher assertResponseLength(Matcher<Integer> count) {
        return mvcResult -> {
            List<ArtifactDto> artifacts = parseSearchResponse(mvcResult);
            assertThat(artifacts, hasSize(count));
        };
    }
    
    private List<ArtifactDto> parseSearchResponse(MvcResult mvcResult) throws java.io.IOException {
        return mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<ArtifactDto>>() {
        });
    }
    
}