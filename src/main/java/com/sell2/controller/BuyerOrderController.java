package com.sell2.controller;

import com.sell2.VO.ResultVo;
import com.sell2.converter.OrderForm2OrderDTOConverter;
import com.sell2.dto.OrderDTO;
import com.sell2.enums.ResultEnum;
import com.sell2.exception.SellException;
import com.sell2.form.OrderForm;
import com.sell2.service.BuyerService;
import com.sell2.service.OrderService;
import com.sell2.utils.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by xjx on 2018/4/18.
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    private static final Logger LOG = LoggerFactory.getLogger(BuyerOrderController.class);
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVo<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            LOG.info("创建订单，参数不正确，orderForm={}",orderForm);
            throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.converter(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            LOG.error("创建订单，购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO orderDTO1 = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<String,String>();
        map.put("orderId",orderDTO1.getOrderId());
        return ResultVoUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVo<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "rows",defaultValue = "10") Integer rows){
        if (StringUtils.isEmpty(openid)){
            LOG.error("订单列表，openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = new PageRequest(page,rows);
        Page<OrderDTO> list = orderService.findList(openid, pageRequest);
        return ResultVoUtil.success(list.getContent());
    }

    //订单详情
    @GetMapping("/detail")
    public ResultVo<List<OrderDTO>> detail(@RequestParam("openid") String openid,
                                         @RequestParam("orderid") String orderid){
        OrderDTO orderOne = buyerService.findOrderOne(openid, orderid);
        return ResultVoUtil.success(orderOne);
    }

    //取消订单
    @GetMapping("/cancel")
    public ResultVo<List<OrderDTO>> cancel(@RequestParam("openid") String openid,
                                           @RequestParam("orderid") String orderid){
        OrderDTO orderOne = buyerService.findOrderOne(openid, orderid);
        return ResultVoUtil.success("");
    }


}
