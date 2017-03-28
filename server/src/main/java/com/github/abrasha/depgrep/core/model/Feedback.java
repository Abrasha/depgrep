package com.github.abrasha.depgrep.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@Table(name = "feedbacks")
public class Feedback extends BaseEntity {
    
    @Column(unique = true)
    private String artifactId;
    
    @Min(0)
    private Integer timesApproved;
    
}
