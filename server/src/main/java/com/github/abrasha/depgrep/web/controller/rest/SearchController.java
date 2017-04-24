package com.github.abrasha.depgrep.web.controller.rest;

import com.github.abrasha.depgrep.core.model.Artifact;
import com.github.abrasha.depgrep.service.ArtifactService;
import com.github.abrasha.depgrep.web.dto.ArtifactDto;
import com.github.abrasha.depgrep.web.dto.SearchRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@RestController
@RequestMapping("/search")
public class SearchController extends AbstractRestController<Artifact, ArtifactDto> {
    
    private static final Logger LOG = LoggerFactory.getLogger(SearchController.class);
    
    private final ArtifactService artifactService;
    
    @Autowired
    public SearchController(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }
    
    @GetMapping(params = "group")
    public List<ArtifactDto> findByGroup(@RequestParam("group") String group) {
        LOG.debug("searching with group = {}", group);
        List<Artifact> result = artifactService.findByGroupName(group);
        List<ArtifactDto> response = convertToDto(result);
        response.sort(Comparator.comparing(ArtifactDto::getLikes).reversed());
        return response;
    }
    
    @GetMapping(params = "artifact")
    public List<ArtifactDto> findByArtifact(@RequestParam("artifact") String artifact) {
        LOG.debug("searching with artifact = {}", artifact);
        List<Artifact> result = artifactService.findByArtifactName(artifact);
        List<ArtifactDto> response = convertToDto(result);
        response.sort(Comparator.comparing(ArtifactDto::getLikes).reversed());
        return response;
    }
    
    @GetMapping(params = {"artifact", "group"})
    public List<ArtifactDto> findByArtifactAndGroup(@ModelAttribute SearchRequest request) {
        LOG.debug("searching with artifact = {} and group = {}", request.getArtifact(), request.getGroup());
        List<Artifact> result = artifactService.findByGroupAndArtifact(request.getGroup(), request.getArtifact());
        List<ArtifactDto> response = convertToDto(result);
        response.sort(Comparator.comparing(ArtifactDto::getLikes).reversed());
        return response;
    }
    
    @GetMapping(params = "q")
    public List<ArtifactDto> findByQuery(@RequestParam("q") String q) {
        LOG.debug("searching with query = {}", q);
        List<Artifact> result = artifactService.findByQuery(q);
        
        return convertToDto(result)
                .stream()
                .sorted(Comparator.comparingInt(ArtifactDto::getLikes).reversed())
                .collect(Collectors.toList());
    }
    
    @Override
    protected Class<Artifact> getEntityClass() {
        return Artifact.class;
    }
    
    @Override
    protected Class<ArtifactDto> getDtoClass() {
        return ArtifactDto.class;
    }
}
