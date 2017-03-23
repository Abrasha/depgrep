package com.github.abrasha.depgrep.service.specification.impl;

import com.github.abrasha.depgrep.service.specification.ArtifactSpecification;

/**
 * @author Andrii Abramov on 3/12/17.
 */
public abstract class AbstractArtifactSpecification implements ArtifactSpecification {
    
    @Override
    public String toString() {
        return getClass().getName() + ": " + getQuery();
    }
}
