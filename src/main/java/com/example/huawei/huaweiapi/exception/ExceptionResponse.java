package com.example.huawei.huaweiapi.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExceptionResponse {

    private Date timestamp;

    private int responseCode;

    private String message;

    private String details;



    public ExceptionResponse(Date timestamp,int responseCode ,String message) {
        this.timestamp = timestamp;
        this.responseCode = responseCode;
        this.message = message;
    }

    public ExceptionResponse(Date timestamp,int responseCode, String message, String details) {
        this.timestamp = timestamp;
        this.responseCode = responseCode;
        this.message = message;
        this.details = details;

    }


}
