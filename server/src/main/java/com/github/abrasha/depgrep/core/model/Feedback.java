package com.github.abrasha.depgrep.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@Table(name = "feedbacks")
public class Feedback extends BaseEntity {
    
    private String artifactId;
    private Integer timesApproved;
    
}
