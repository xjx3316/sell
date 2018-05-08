package com.sell2.controller;

import com.sell2.VO.ProductInfoVo;
import com.sell2.VO.ProductVo;
import com.sell2.VO.ResultVo;
import com.sell2.dataobject.ProductCategory;
import com.sell2.dataobject.ProductInfo;
import com.sell2.service.CategoryService;
import com.sell2.service.ProductService;
import com.sell2.utils.ResultVoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created by xjx on 2018/4/17.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list() {
        ResultVo resultVo = new ResultVo();
        //查询所有上架的商品
        List<ProductInfo> upAll = productService.findUpAll();
        //获取upAll中的productType，java8新特性 lambda
        List<Integer> collect = upAll.stream().map(e -> e.getProductType()).collect(Collectors.toList());
        //查询类目(一次性查询)
        List<ProductCategory> productCategoryList = categoryService.findAllByCategoryTypeIn(collect);
        //数据拼接
        List<ProductVo> productVoList = new ArrayList<ProductVo>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVo> productInfoVoList = new ArrayList<ProductInfoVo>();
            for (ProductInfo productInfo : upAll) {
                if (productInfo.getProductType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }
        return ResultVoUtil.success(productVoList);
    }
}
