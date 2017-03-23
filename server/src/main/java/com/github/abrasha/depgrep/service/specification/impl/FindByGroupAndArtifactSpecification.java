package com.github.abrasha.depgrep.service.specification.impl;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class FindByGroupAndArtifactSpecification extends AbstractArtifactSpecification {
    
    private final String group;
    private final String artifact;
    
    public FindByGroupAndArtifactSpecification(String group, String artifact) {
        this.group = group;
        this.artifact = artifact;
    }
    
    @Override
    public String getQuery() {
        return "g:" + group + "+AND+a:" + artifact;
    }
}
