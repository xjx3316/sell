package com.sell2.enums;

/**
 * Created by xjx on 2018/4/18.
 */
public enum ResultEnum {

    PARAM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    UPDATE_ORDER_STATUS_FAIL(15,"更新订单状态失败"),
    CART_EMPTY(16,"购物车为空"),
    ORDER_DETAIL_EMPTY(17,"订单详情为空"),
    PAY_STATUS_ERROR(18,"订单支付状态不正确"),
    ORDER_OWNER_ERROR(19,"订单id与当前账户id不符"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
