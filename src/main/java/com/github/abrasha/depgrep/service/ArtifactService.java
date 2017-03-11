package com.github.abrasha.depgrep.service;

import com.github.abrasha.depgrep.core.model.Artifact;

/**
 * @author Andrii Abramov on 3/12/17.
 */
public interface ArtifactService {
    Artifact approveQuery(String query, Artifact artifact);
}
