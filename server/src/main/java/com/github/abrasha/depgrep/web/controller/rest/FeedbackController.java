package com.github.abrasha.depgrep.web.controller.rest;

import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.service.FeedbackResolver;
import com.github.abrasha.depgrep.web.dto.FeedbackDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@RestController
@RequestMapping("/approve")
public class FeedbackController extends AbstractRestController<Feedback, FeedbackDto> {
    
    private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);
    
    private final FeedbackResolver feedbackResolver;
    
    @Autowired
    public FeedbackController(FeedbackResolver feedbackResolver) {
        this.feedbackResolver = feedbackResolver;
    }
    
    @PostMapping("/{artifactId:.*:.*}")
    public FeedbackDto approveArtifact(@PathVariable("artifactId") String artifactId) {
        logger.debug("approveArtifact: {}", artifactId);
        Feedback response = feedbackResolver.likeArtifact(artifactId);
        return convertToDto(response);
    }
    
    @Override
    protected Class<Feedback> getEntityClass() {
        return Feedback.class;
    }
    
    @Override
    protected Class<FeedbackDto> getDtoClass() {
        return FeedbackDto.class;
    }
}
