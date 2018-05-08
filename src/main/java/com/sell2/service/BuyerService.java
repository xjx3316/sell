package com.sell2.service;

import com.sell2.dto.OrderDTO;

/**
 * Created by xjx on 2018/4/24.
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openid,String orderid);

    OrderDTO cancleOrder(String openid,String orderid);
}
