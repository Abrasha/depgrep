package com.github.abrasha.depgrep.web.controller.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * @author Andrii Abramov on 3/12/17.
 */
@Component
public class AbstractController {
    
    @Autowired
    private ModelMapper modelMapper;
    
    
    
    
}
