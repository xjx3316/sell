package com.sell2.dto;

/**
 * Created by xjx on 2018/4/18.
 */
public class CartDTO {

    private String productId;//商品id
    private Integer productQuantity;//商品数量

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "productId='" + productId + '\'' +
                ", productQuantity='" + productQuantity + '\'' +
                '}';
    }
}
