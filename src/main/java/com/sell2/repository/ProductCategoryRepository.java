package com.sell2.repository;

import com.sell2.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xjx on 2018/4/13.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>
{
    List<ProductCategory> findAllByCategoryTypeIn(List<Integer> l);
}
