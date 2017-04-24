package com.github.abrasha.depgrep.persistence;

import com.github.abrasha.depgrep.core.model.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Repository
public interface FeedbackRepository extends EntityRepository<Feedback> {
    
    Feedback findOneByArtifactId(String artifactId);
    
    List<Feedback> findAll();
    
    List<Feedback> findTop5ByOrderByTimesApprovedDesc();
    
    List<Feedback> findAllByArtifactId(String artifactId);
    
}
