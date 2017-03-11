package com.github.abrasha.depgrep.web.request;

/**
 * @author Andrii Abramov on 3/12/17.
 */
public abstract class AbstractArtifactSpecification implements ArtifactSpecification {
    
    @Override
    public String toString() {
        return getClass().getName() + ": " + getQuery();
    }
}
