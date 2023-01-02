package org.csu.webJpetStore.persistence;

import org.csu.webJpetStore.domain.LineItem;

import java.util.List;

public interface LineItemDAO {
    List<LineItem> getLineItemsByOrderId(int orderId);

    void insertLineItem(LineItem lineItem);
}
