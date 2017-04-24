package com.github.abrasha.depgrep.web.controller.rest;

import com.github.abrasha.depgrep.core.model.Feedback;
import com.github.abrasha.depgrep.service.FeedbackService;
import com.github.abrasha.depgrep.web.dto.FeedbackDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@RestController
@RequestMapping("/artifacts")
public class FeedController extends AbstractRestController<Feedback, FeedbackDto> {
    
    private static final Logger logger = LoggerFactory.getLogger(FeedController.class);
    
    private final FeedbackService feedbackService;
    
    @Autowired
    public FeedController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }
    
    @GetMapping("/popular")
    public List<FeedbackDto> getMostUsefulArtifacts() {
        logger.debug("getMostUsefulArtifacts");
        List<Feedback> response = feedbackService.getTopUsedArtifacts();
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
