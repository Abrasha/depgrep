package com.github.abrasha.depgrep.web.request;

/**
 * @author Andrii Abramov on 3/11/17.
 */
public class FindByArtifactSpecification extends AbstractArtifactSpecification {
    
    private String artifact;
    
    public FindByArtifactSpecification(String artifact) {
        this.artifact = artifact;
    }
    
    @Override
    public String getQuery() {
        return "a:\"" + artifact + "\"";
    }
}
