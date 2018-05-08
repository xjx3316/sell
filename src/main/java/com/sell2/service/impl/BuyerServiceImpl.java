package com.sell2.service.impl;

import com.sell2.dto.OrderDTO;
import com.sell2.enums.ResultEnum;
import com.sell2.exception.SellException;
import com.sell2.service.BuyerService;
import com.sell2.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xjx on 2018/4/24.
 */
@Service
public class BuyerServiceImpl implements BuyerService {

    private static final Logger LOG = LoggerFactory.getLogger(BuyerServiceImpl.class);
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderid) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderid);
        return orderDTO;
    }

    @Override
    public OrderDTO cancleOrder(String openid, String orderid) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderid);
        OrderDTO cancel = orderService.cancel(orderDTO);
        return orderDTO;
    }

    public OrderDTO checkOrderOwner(String openid, String orderid){
        OrderDTO orderDTO = orderService.findOne(orderid);
        if (orderDTO == null){
            return null;
        }
        if (orderDTO.getOrderId().equalsIgnoreCase(openid)){
            LOG.info("订单的openid不一致，openid={}，orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
