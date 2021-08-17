package com.example.springmvc2.core.exception;

import com.example.springmvc2.constants.ServiceExceptionEnum;

public final class ServiceException extends RuntimeException{
    private final Integer code;

    public ServiceException(ServiceExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
