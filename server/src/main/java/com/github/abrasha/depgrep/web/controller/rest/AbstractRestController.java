package com.github.abrasha.depgrep.web.controller.rest;

import com.github.abrasha.depgrep.core.model.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrii Abramov on 3/20/17.
 */
public abstract class AbstractRestController<Entity extends BaseEntity, Dto> {
    
    @Autowired
    private ModelMapper modelMapper;
    
    protected Entity convertToEntity(Dto dto) {
        return modelMapper.map(dto, getEntityClass());
    }
    
    protected List<Entity> convertToEntity(Collection<Dto> dtos) {
        return dtos.stream()
                .map(dto -> modelMapper.map(dto, getEntityClass()))
                .collect(Collectors.toList());
    }
    
    protected Dto convertToDto(Entity entity) {
        return modelMapper.map(entity, getDtoClass());
    }
    
    protected List<Dto> convertToDto(Collection<Entity> entities) {
        return entities.stream()
                .map(dto -> modelMapper.map(dto, getDtoClass()))
                .collect(Collectors.toList());
    }
    
    protected abstract Class<Entity> getEntityClass();
    
    protected abstract Class<Dto> getDtoClass();
    
}
