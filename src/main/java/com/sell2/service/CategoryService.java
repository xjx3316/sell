package com.sell2.service;


import com.sell2.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by xjx on 2018/4/16.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findAllByCategoryTypeIn(List<Integer> l);

    ProductCategory save(ProductCategory productCategory);
}
