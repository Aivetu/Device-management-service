package com.nimisi.device_management_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class DeviceException extends RuntimeException{
    public DeviceException(String message){
        super(message);
    }
}
