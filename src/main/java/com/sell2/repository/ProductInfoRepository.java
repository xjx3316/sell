package com.sell2.repository;

import com.sell2.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by xjx on 2018/4/16.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    ProductInfo save(ProductInfo productInfo);

    List<ProductInfo> findAllByProductStatusIn(List<Integer> l);

}
