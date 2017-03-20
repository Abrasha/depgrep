package com.github.abrasha.depgrep.web.dto;

import lombok.Data;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Data
public class ArtifactDto {
    
    private String group;
    private String artifact;
    private String version;
    
    private Integer likes;
    
}
