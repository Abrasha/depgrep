package com.github.abrasha.depgrep.service.specification;

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
