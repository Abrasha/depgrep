package com.github.abrasha.depgrep.service.specification;

import com.github.abrasha.depgrep.web.request.AbstractArtifactSpecification;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class FindByGroupSpecification extends AbstractArtifactSpecification {
    
    private String groupId;
    
    public FindByGroupSpecification(String groupId) {
        this.groupId = groupId;
    }
    
    @Override
    public String getQuery() {
        return "g:" + groupId;
    }
}
