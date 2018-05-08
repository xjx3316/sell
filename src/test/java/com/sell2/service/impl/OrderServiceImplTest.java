/*
package com.sell2.service.impl;

import com.sell2.dataobject.OrderDetail;
import com.sell2.dto.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

*/
/**
 * Created by xjx on 2018/4/18.
 *//*

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImplTest.class);
    private final String BUYER_OPENID = "110110";
    private final String ORDER_ID = "1524044665387938434";
    @Autowired
    private OrderServiceImpl orderService;
    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerName("xjx");
        orderDTO.setBuyerPhone("15311111111");
        orderDTO.setBuyerAddress("北京");

        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("aaa");
        orderDetail.setProductQuantity(2);
        orderDetailList.add(orderDetail);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        LOG.info("result={}",result);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        LOG.info("orderDTO={}",orderDTO);
    }

    @Test
    public void findList() throws Exception {

    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO =  orderService.findOne(ORDER_ID);
        OrderDTO cancel = orderService.cancel(orderDTO);
        LOG.info("cancel={}",cancel);
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO =  orderService.findOne(ORDER_ID);
        OrderDTO finish = orderService.finish(orderDTO);
        LOG.info("finish={}",finish);
    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO =  orderService.findOne(ORDER_ID);
        OrderDTO paid = orderService.paid(orderDTO);
        LOG.info("paid={}",paid);
    }

}*/
