package com.github.abrasha.depgrep.core.model;

import org.springframework.stereotype.Component;

/**
 * @author Andrii Abramov on 3/21/17.
 */
@Component
public class ArtifactGenerator {
    
    public static class Valid {
        public static final String ARTIFACT_NAME = "guice";
        public static final String GROUP = "com.google.inject";
        public static final String ARTIFACT_ID = GROUP + ":" + ARTIFACT_NAME;
    }
    
    public static class Invalid {
        public static final String ARTIFACT_NAME = "i.am.invalid.artifact";
        public static final String GROUP = "i.am.invalid.group";
        public static final String ARTIFACT_ID = GROUP + ":" + ARTIFACT_NAME;
    }
    
    public Artifact getValidArtifact() {
        Artifact artifact = new Artifact();
        artifact.setArtifact(Valid.ARTIFACT_NAME);
        artifact.setGroup(Valid.GROUP);
        return artifact;
    }
    
    public Artifact getInvalidArtifact() {
        Artifact artifact = new Artifact();
        artifact.setArtifact(Invalid.ARTIFACT_NAME);
        artifact.setGroup(Invalid.GROUP);
        return artifact;
    }
    
}
