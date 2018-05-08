package com.sell2.enums;

/**
 * Created by xjx on 2018/4/16.
 */
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架");
    private Integer code;
    private String message;

    ProductStatusEnum() {
    }

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ProductStatusEnum{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
