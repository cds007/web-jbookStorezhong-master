package org.csu.webJpetStore.persistence;

import org.csu.webJpetStore.domain.Order;

import java.util.List;

public interface OrderDAO {
    /**通过用户名获取订单**/
    List<Order> getOrdersByUsername(String username);

    Order getOrder(int orderId);

    void insertOrder(Order order);

    void insertOrderStatus(Order order);
}
