package com.github.abrasha.depgrep.web.controller.rest;

import com.github.abrasha.depgrep.core.model.Artifact;
import com.github.abrasha.depgrep.service.ArtifactProvider;
import com.github.abrasha.depgrep.web.dto.SearchRequest;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@RestController("/")
public class SearchController {
    
    private static final Logger log = LoggerFactory.getLogger(SearchController.class);
    
    private final ArtifactProvider<Artifact> artifactArtifactProvider;
    private final ModelMapper modelMapper;
    
    @Autowired
    public SearchController(ArtifactProvider<Artifact> artifactArtifactProvider, ModelMapper modelMapper) {
        this.artifactArtifactProvider = artifactArtifactProvider;
        this.modelMapper = modelMapper;
    }
    
    @GetMapping(params = "group")
    public List<Artifact> findByGroup(@RequestParam("group") String group) {
        log.debug("searching with group = {}", group);
        return artifactArtifactProvider.findByGroupName(group);
    }
    
    @GetMapping(params = "artifact")
    public List<Artifact> findByArtifact(@RequestParam("artifact") String artifact) {
        log.debug("searching with artifact = {}", artifact);
        return artifactArtifactProvider.findByArtifactName(artifact);
    }
    
    @GetMapping(params = {"artifact", "group"})
    public List<Artifact> findByArtifactAndGroup(@ModelAttribute SearchRequest request) {
        log.debug("searching with artifact = {} and group = {}", request.getArtifact(), request.getGroup());
        return artifactArtifactProvider.findByGroupAndArtifact(request.getGroup(), request.getArtifact());
    }
    
    @GetMapping(params = "q")
    public List<Artifact> findByQuery(@RequestParam("q") String q) {
        log.debug("searching with query = {}", q);
        return artifactArtifactProvider.findByQuery(q);
    }
    
}
