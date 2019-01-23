package com.rdxer.springjpa.exception.exceptions;

import org.springframework.validation.Errors;

/**
 * 参数无效请求异常
 */
//@SuppressWarnings("serial")
public class InvalidRequestException extends BaseException {
    private final Errors errors;

    public InvalidRequestException(Errors errors) {
        super("");
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
