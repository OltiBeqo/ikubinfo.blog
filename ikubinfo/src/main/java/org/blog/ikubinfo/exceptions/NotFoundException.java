package org.blog.ikubinfo.exceptions;

import org.springframework.boot.context.properties.bind.handler.NoUnboundElementsBindHandler;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }
}
