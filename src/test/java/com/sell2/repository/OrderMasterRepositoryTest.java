package com.sell2.repository;

import com.sell2.dataobject.OrderMaster;
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
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by xjx on 2018/4/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(OrderMasterRepositoryTest.class);
    private static final String openid = "110110";
    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("qwertyuioqwert");
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerPhone("15211111111");
        orderMaster.setBuyerAddress("北京");
        orderMaster.setBuyerOpenid(openid);
        orderMaster.setOrderAmount(new BigDecimal(2.35));
        OrderMaster save = repository.save(orderMaster);
        Assert.assertNotEquals(null,save);
        LOG.info("save={}",save);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderMaster> byBuyerOpenid = repository.findByBuyerOpenid(openid, pageRequest);
        Iterator<OrderMaster> iterator = byBuyerOpenid.iterator();
        while(iterator.hasNext()){
            LOG.info("OrderMaster={}",iterator.next());
        }
    }

}