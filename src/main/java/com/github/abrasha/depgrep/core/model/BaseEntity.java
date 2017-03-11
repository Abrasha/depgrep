package com.github.abrasha.depgrep.core.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@MappedSuperclass
public abstract class BaseEntity {
    
    @Id
    @GeneratedValue
    private Long id;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}
