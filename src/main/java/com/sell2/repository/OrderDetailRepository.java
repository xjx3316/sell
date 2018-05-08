package com.sell2.repository;

import com.sell2.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xjx on 2018/4/18.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    /**
     * 通过订单id查询订单详情信息
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
