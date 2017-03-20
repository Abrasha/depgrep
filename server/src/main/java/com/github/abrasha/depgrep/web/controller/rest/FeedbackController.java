package com.github.abrasha.depgrep.web.controller.rest;

import com.github.abrasha.depgrep.service.ArtifactService;
import com.github.abrasha.depgrep.web.dto.ApproveDto;
import com.github.abrasha.depgrep.web.dto.FeedbackDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@RestController("/approve")
public class FeedbackController {
    
    private static final Logger LOG = LoggerFactory.getLogger(FeedbackController.class);
    
    private final ArtifactService artifactService;
    private final ModelMapper modelMapper;
    
    @Autowired
    public FeedbackController(ArtifactService artifactService, ModelMapper modelMapper) {
        this.artifactService = artifactService;
        this.modelMapper = modelMapper;
    }
    
    @PostMapping
    public FeedbackDto approveArtifact(@RequestBody ApproveDto approveDto) {
        LOG.debug("approveArtifact: {}", approveDto);
        return modelMapper.map(
                artifactService.approveQuery(approveDto.getQuery(), approveDto.getArtifactId()),
                FeedbackDto.class
        );
    }
    
}
