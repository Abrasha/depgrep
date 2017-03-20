package com.github.abrasha.depgrep.web.dto;

import lombok.Data;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@Data
public class ApproveDto {
    
    private String query;
    private String artifactId;
    
}
