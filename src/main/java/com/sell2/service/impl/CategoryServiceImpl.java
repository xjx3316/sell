package com.sell2.service.impl;

import com.sell2.dataobject.ProductCategory;
import com.sell2.repository.ProductCategoryRepository;
import com.sell2.service.CategoryService;
import com.sell2.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by xjx on 2018/4/16.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;
    @Override
    public ProductCategory findOne(Integer categoryId) {
        ProductCategory one = repository.findOne(categoryId);
        return one;
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findAllByCategoryTypeIn(List<Integer> l) {
        return repository.findAllByCategoryTypeIn(l);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        String now = DateUtil.getNow();
        productCategory.setCreateTime(now);
        return repository.save(productCategory);
    }
}
