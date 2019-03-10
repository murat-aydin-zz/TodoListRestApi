package com.example.huawei.huaweiapi.constant;

public enum Constant {
    SUCCESS("Success"),
    FAILED("Failed")
    ;

    private final String text;

    Constant(String text){
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
