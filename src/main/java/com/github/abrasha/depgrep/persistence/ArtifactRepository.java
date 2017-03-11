package com.github.abrasha.depgrep.persistence;

import com.github.abrasha.depgrep.core.model.Artifact;
import org.springframework.stereotype.Repository;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Repository
public interface ArtifactRepository extends EntityRepository<Artifact> {
}
