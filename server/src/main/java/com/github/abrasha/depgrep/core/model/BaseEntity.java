package com.github.abrasha.depgrep.core.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@MappedSuperclass
@Data
public abstract class BaseEntity {
    
    @Id
    @GeneratedValue
    private Long id;
    
}
