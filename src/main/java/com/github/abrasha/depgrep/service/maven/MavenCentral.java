package com.github.abrasha.depgrep.service.maven;

import com.github.abrasha.depgrep.service.specification.ArtifactSpecification;
import com.github.abrasha.depgrep.web.dto.maven.MavenCentralSearchResponse;

/**
 * @author Andrii Abramov on 3/15/17.
 */
public interface MavenCentral {
    
    MavenCentralSearchResponse query(ArtifactSpecification specification);
    
}
