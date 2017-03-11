package com.github.abrasha.depgrep.web.request;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class FindByGroupSpecification implements ArtifactSpecification {
    
    private String groupId;
    
    public FindByGroupSpecification(String groupId) {
        this.groupId = groupId;
    }
    
    @Override
    public String getQuery() {
        return "g:\"" + groupId + "\"";
    }
}
