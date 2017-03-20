package com.github.abrasha.depgrep.service.specification;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class FindByQuerySpecification extends AbstractArtifactSpecification {
    
    private String query;
    
    public FindByQuerySpecification(String query) {
        this.query = query;
    }
    
    @Override
    public String getQuery() {
        return query;
    }
}
