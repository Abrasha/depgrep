package com.github.abrasha.depgrep.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@EqualsAndHashCode(callSuper = false)
@Entity
@Data
public class Artifact extends BaseEntity {
    
    private String group;
    private String artifact;
    
    private String version;
    
    private Integer likes;
    
}
