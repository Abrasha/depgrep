package com.github.abrasha.depgrep.persistence;

import com.github.abrasha.depgrep.core.model.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Repository
public interface FeedbackRepository extends EntityRepository<Feedback> {
    
    List<Feedback> findByArtifactId(String artifactId);
    Feedback findOneByArtifactId(String artifactId);
    
    Feedback findOneByArtifactIdAndQuery(String artifactId, String query);
    
}
