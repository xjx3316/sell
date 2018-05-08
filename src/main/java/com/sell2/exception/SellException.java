package com.sell2.exception;

import com.sell2.enums.ResultEnum;

/**
 * Created by xjx on 2018/4/18.
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message){
        super(message);
        this.code = code;
    }

}
