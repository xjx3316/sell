package com.sell2.service.impl;

import com.sell2.dataobject.ProductInfo;
import com.sell2.dto.CartDTO;
import com.sell2.enums.ProductStatusEnum;
import com.sell2.enums.ResultEnum;
import com.sell2.exception.SellException;
import com.sell2.repository.ProductInfoRepository;
import com.sell2.service.ProductService;
import com.sell2.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xjx on 2018/4/16.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo one = repository.findOne(productId);
        return one;
    }

    @Override
    public List<ProductInfo> findUpAll() {
        List<ProductInfo> allByProductStatus = repository.findAllByProductStatusIn(Arrays.asList(ProductStatusEnum.UP.getCode()));
        return allByProductStatus;
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        Page<ProductInfo> all = repository.findAll(pageable);
        return all;
    }

    @Override
    public List<ProductInfo> findAllByProductStatus(List<Integer> l) {
        List<ProductInfo> allByProductStatus = repository.findAllByProductStatusIn(l);
        return allByProductStatus;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        String now = DateUtil.getNow();
        productInfo.setCreateTime(now);
        ProductInfo save = repository.save(productInfo);
        return save;
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int i = productInfo.getProductStock() + cartDTO.getProductQuantity();

            productInfo.setProductStock(i);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int i = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (i < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(i);
            repository.save(productInfo);
        }
    }
}
