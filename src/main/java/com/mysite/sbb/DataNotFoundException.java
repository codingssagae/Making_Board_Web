package com.mysite.sbb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found") // 실행 안댐 고쳐야함
public class DataNotFoundException extends RuntimeException {

    private static final Long serialVersionUID = 1L;

    public DataNotFoundException() {
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}
