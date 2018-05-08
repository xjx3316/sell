/*
package com.sell2.service.impl;

import com.sell2.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

*/
/**
 * Created by xjx on 2018/4/16.
 *//*

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    public static final Logger LOG = LoggerFactory.getLogger(ProductServiceImplTest.class);
    @Autowired
    private ProductServiceImpl service;
    @Test
    public void findOne() throws Exception {
        ProductInfo one = service.findOne("123");
        Assert.assertEquals("笔记本",one.getProductName());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> upAll = service.findUpAll();
        Assert.assertEquals(2,upAll.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> all = service.findAll(request);
        LOG.info("all={}",all);
    }

    @Test
    public void findAllByProductStatus() throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        List<ProductInfo> allByProductStatus = service.findAllByProductStatus(list);
        Assert.assertEquals(3,allByProductStatus.size());
    }

    @Test
    public void save() throws Exception {
        ProductInfo p = new ProductInfo();
        p.setProductId("aaa");
        p.setProductName("图书馆");
        p.setProductDescription("图书馆图书");
        p.setProductIcon("www.def.com");
        p.setProductPrice(new BigDecimal(6.56));
        p.setProductStatus(1);
        p.setProductStock(120);
        p.setProductType(456);
        ProductInfo save = service.save(p);
        Assert.assertNotEquals(null,save);
    }

}*/
