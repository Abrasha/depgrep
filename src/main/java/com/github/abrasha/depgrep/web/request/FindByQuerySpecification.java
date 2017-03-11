package com.github.abrasha.depgrep.web.request;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class FindByQuerySpecification implements ArtifactSpecification {
    
    private String query;
    
    public FindByQuerySpecification(String query) {
        this.query = query;
    }
    
    @Override
    public String getQuery() {
        return query;
    }
}
