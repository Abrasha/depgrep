package com.github.abrasha.depgrep.web.dto;

import com.github.abrasha.depgrep.core.model.ArtifactId;
import lombok.Data;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Data
public class SearchRequest implements ArtifactId {
    
    private String group;
    private String artifact;
    
    @Override
    public String getArtifactId() {
        return group + ":" + artifact;
    }
    
}
