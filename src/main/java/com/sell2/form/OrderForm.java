package com.sell2.form;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by xjx on 2018/4/18.
 */
public class OrderForm implements Serializable{

    @NotEmpty(message = "名字必填")
    private String name;
    @NotEmpty(message = "手机号必填")
    private String phone;
    @NotEmpty(message = "地址必填")
    private String address;
    @NotEmpty(message = "openid必填")
    private String openid;
    @NotEmpty(message = "购物车不能为空")
    private String item;

    public OrderForm() {
    }

    public OrderForm(String name, String phone, String address, String openid, String item) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.openid = openid;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", openid='" + openid + '\'' +
                ", item='" + item + '\'' +
                '}';
    }
}
