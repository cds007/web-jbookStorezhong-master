package org.csu.webJpetStore.service;

import org.csu.webJpetStore.domain.Item;
import org.csu.webJpetStore.domain.LineItem;
import org.csu.webJpetStore.domain.Order;
import org.csu.webJpetStore.domain.Sequence;
import org.csu.webJpetStore.persistence.Impl.ItemDAOImpl;
import org.csu.webJpetStore.persistence.Impl.LineItemDAOImpl;
import org.csu.webJpetStore.persistence.Impl.OrderDAOImpl;
import org.csu.webJpetStore.persistence.Impl.SequenceDAOImpl;
import org.csu.webJpetStore.persistence.ItemDAO;
import org.csu.webJpetStore.persistence.LineItemDAO;
import org.csu.webJpetStore.persistence.OrderDAO;
import org.csu.webJpetStore.persistence.SequenceDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private ItemDAO itemDAO;
    private OrderDAO orderDAO;
    private SequenceDAO sequenceDAO;
    private LineItemDAO lineItemDAO;

    public OrderService(){
        itemDAO = new ItemDAOImpl();
        orderDAO = new OrderDAOImpl();
        sequenceDAO = new SequenceDAOImpl();
        lineItemDAO = new LineItemDAOImpl();
    }
    /**从订单编号表里通过ordernum查nextId**/
    public int getNextId(String name) {
        Sequence sequence = new Sequence(name, -1);
        sequence = sequenceDAO.getSequence(sequence);
        if (sequence == null) {
            throw new RuntimeException("Error: A null sequence was returned from the database (could not get next " + name
                    + " sequence).");
        }
        Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
        sequenceDAO.updateSequence(parameterObject);
        return sequence.getNextId();
    }

    public void insertOrder(Order order) {
        order.setOrderId(getNextId("ordernum"));
        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            String itemId = lineItem.getItemId();
            Integer increment = new Integer(lineItem.getQuantity());
            String increment1 = Integer.toString(increment);
            /**修改一下**/
            Map<String, String> param = new HashMap<String, String>(2);
            param.put("itemId", itemId);
            param.put("increment", increment1);
            itemDAO.updateInventoryQuantity(param);
        }

        orderDAO.insertOrder(order);
        orderDAO.insertOrderStatus(order);
        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            lineItem.setOrderId(order.getOrderId());
            lineItemDAO.insertLineItem(lineItem);
        }
    }

    public Order getOrder(int orderId) {
        Order order = orderDAO.getOrder(orderId);
        order.setLineItems(lineItemDAO.getLineItemsByOrderId(orderId));

        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            Item item = itemDAO.getItem(lineItem.getItemId());
            item.setQuantity(itemDAO.getInventoryQuantity(lineItem.getItemId()));
            lineItem.setItem(item);
        }

        return order;
    }

    public List<Order> getOrdersByUsername(String username) {
        return orderDAO.getOrdersByUsername(username);
    }

}
