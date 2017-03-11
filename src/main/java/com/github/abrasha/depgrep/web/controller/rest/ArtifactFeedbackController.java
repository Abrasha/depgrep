package com.github.abrasha.depgrep.web.controller.rest;

import com.github.abrasha.depgrep.core.model.Artifact;
import com.github.abrasha.depgrep.service.ArtifactService;
import com.github.abrasha.depgrep.web.dto.ApproveDto;
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
@RestController("/")
public class ArtifactFeedbackController {
    
    private static final Logger log = LoggerFactory.getLogger(ArtifactFeedbackController.class);
    
    private final ArtifactService artifactService;
    private final ModelMapper modelMapper;
    
    @Autowired
    public ArtifactFeedbackController(ArtifactService artifactService, ModelMapper modelMapper) {
        this.artifactService = artifactService;
        this.modelMapper = modelMapper;
    }
    
    @PostMapping("/approve")
    public Artifact approveArtifact(@RequestBody ApproveDto approveDto) {
        return artifactService.approveQuery(approveDto.getQuery(), approveDto.getArtifact());
    }
    
}
