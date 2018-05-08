package com.sell2.repository;

import com.sell2.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xjx on 2018/4/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(OrderDetailRepositoryTest.class);
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save() throws Exception {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("qwerty123");
        orderDetail.setOrderId("qwertyuio");
        orderDetail.setProductId("123");
        orderDetail.setProductName("蒙牛");
        orderDetail.setProductPrice(new BigDecimal(1));
        orderDetail.setProductQuantity(5);
        orderDetail.setProductIcon("www.a56c.com");
        OrderDetail save = repository.save(orderDetail);
        Assert.assertNotEquals(null,save);

    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> qwertyuio = repository.findByOrderId("qwertyuio");
        Assert.assertEquals(2,qwertyuio.size());
    }

}