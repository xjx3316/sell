package com.sell2.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sell2.dataobject.OrderDetail;
import com.sell2.dto.OrderDTO;
import com.sell2.enums.ResultEnum;
import com.sell2.exception.SellException;
import com.sell2.form.OrderForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjx on 2018/4/18.
 */
public class OrderForm2OrderDTOConverter {

    private static final Logger LOG = LoggerFactory.getLogger(OrderForm2OrderDTOConverter.class);
    public static OrderDTO converter(OrderForm orderForm){
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItem(),new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            LOG.error("对象转换错误，string={}",orderForm.getItem());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
