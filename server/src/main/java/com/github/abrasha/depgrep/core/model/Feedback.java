package com.github.abrasha.depgrep.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@EqualsAndHashCode(callSuper = false)
@Entity
@Data
public class Feedback extends BaseEntity {
    
    private String query;
    private Integer timesApproved;
    
    @Column(unique = true)
    private String artifactId;
    
}
