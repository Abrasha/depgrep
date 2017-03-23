package com.github.abrasha.depgrep.web.controller.rest;

import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.service.FeedbackResolver;
import com.github.abrasha.depgrep.web.dto.FeedbackDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@RestController
@RequestMapping("/approve")
public class FeedbackController {
    
    private static final Logger LOG = LoggerFactory.getLogger(FeedbackController.class);
    
    private final FeedbackResolver feedbackResolver;
    private final ModelMapper modelMapper;
    
    @Autowired
    public FeedbackController(FeedbackResolver feedbackResolver, ModelMapper modelMapper) {
        this.feedbackResolver = feedbackResolver;
        this.modelMapper = modelMapper;
    }
    
    @PostMapping("/{artifactId:.*:.*}")
    public FeedbackDto approveArtifact(@PathVariable("artifactId") String artifactId) {
        LOG.debug("approveArtifact: {}", artifactId);
        Feedback response = feedbackResolver.likeArtifact(artifactId);
        return modelMapper.map(response, FeedbackDto.class);
    }
    
}
