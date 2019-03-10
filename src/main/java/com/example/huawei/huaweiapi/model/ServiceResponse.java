package com.example.huawei.huaweiapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResponse<T> {
    private int responseCode;

    private String message;

    private T data;
}
