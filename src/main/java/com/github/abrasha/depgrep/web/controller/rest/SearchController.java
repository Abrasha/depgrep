package com.github.abrasha.depgrep.web.controller.rest;

import com.github.abrasha.depgrep.core.model.Artifact;
import com.github.abrasha.depgrep.service.ArtifactProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@RestController("/")
public class SearchController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);
    
    private final ArtifactProvider<Artifact> artifactArtifactProvider;
    
    @Autowired
    public SearchController(ArtifactProvider<Artifact> artifactArtifactProvider) {
        this.artifactArtifactProvider = artifactArtifactProvider;
    }
    
    @GetMapping(params = "group")
    public List<Artifact> findByGroup(@RequestParam("group") String group) {
        return artifactArtifactProvider.findByGroupName(group);
    }
    
    @GetMapping(params = "artifact")
    public List<Artifact> findByArtifact(@RequestParam("artifact") String group) {
        return artifactArtifactProvider.findByArtifactName(group);
    }
    
    @GetMapping(params = "q")
    public List<Artifact> findByQuery(@RequestParam("q") String group) {
        return artifactArtifactProvider.findByQuery(group);
    }
    
}
