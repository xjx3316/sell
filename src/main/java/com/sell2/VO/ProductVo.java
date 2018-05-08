package com.sell2.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品(包含类目)
 * Created by xjx on 2018/4/17.
 */
@Data
public class ProductVo {

    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;

    public ProductVo() {
    }

    public ProductVo(String categoryName, Integer categoryType, List<ProductInfoVo> productInfoVoList) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.productInfoVoList = productInfoVoList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public List<ProductInfoVo> getProductInfoVoList() {
        return productInfoVoList;
    }

    public void setProductInfoVoList(List<ProductInfoVo> productInfoVoList) {
        this.productInfoVoList = productInfoVoList;
    }

    @Override
    public String toString() {
        return "ProductVo{" +
                "categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                ", productInfoVoList=" + productInfoVoList +
                '}';
    }
}
