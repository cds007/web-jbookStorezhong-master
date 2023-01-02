package org.csu.webJpetStore.persistence.Impl;

import org.csu.webJpetStore.domain.Item;
import org.csu.webJpetStore.domain.Product;
import org.csu.webJpetStore.persistence.DBUtil;
import org.csu.webJpetStore.persistence.ItemDAO;
import org.csu.webJpetStore.persistence.ProductDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemDAOImpl implements ItemDAO {

    private static final String updateInventoryQuantityString = "UPDATE INVENTORY SET QTY = QTY - ? " +
            "WHERE ITEMID = ?";
    private static final String getInventoryQuantityString = "SELECT QTY AS value FROM INVENTORY WHERE ITEMID = ?";
    private static final String getItemListByProductString = "SELECT I.ITEMID, LISTPRICE, UNITCOST, " +
            "SUPPLIER AS supplierId, I.PRODUCTID AS \"product.productId\", NAME AS \"product.name\", " +
            " DESCN AS \"product.description\", CATEGORY AS \"product.categoryId\", STATUS,  ATTR1 AS attribute1, " +
            "ATTR2 AS attribute2, ATTR3 AS attribute3, ATTR4 AS attribute4, ATTR5 AS attribute5 FROM ITEM I, PRODUCT P " +
            "WHERE P.PRODUCTID = I.PRODUCTID AND I.PRODUCTID = ?";
    private static final String getItemString = "select I.ITEMID, LISTPRICE, UNITCOST, SUPPLIER AS supplierId, " +
            "I.PRODUCTID AS \"product.productId\", NAME AS \"product.name\", DESCN AS \"product.description\", " +
            "CATEGORY AS \"product.categoryId\", STATUS, ATTR1 AS attribute1, ATTR2 AS attribute2, " +
            "ATTR3 AS attribute3, ATTR4 AS attribute4, ATTR5 AS attribute5, QTY AS quantity from ITEM I, " +
            "INVENTORY V, PRODUCT P where P.PRODUCTID = I.PRODUCTID and I.ITEMID = V.ITEMID and I.ITEMID = ?";


    @Override
    public void updateInventoryQuantity(Map<String, String> param) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection.prepareStatement(updateInventoryQuantityString);
            String itemId = param.keySet().iterator().next();
            String increment1 =param.get("increment");
            Integer increment = Integer.valueOf(increment1);
            pStatement.setInt(1, increment.intValue());
            pStatement.setString(2, itemId);
            pStatement.executeUpdate();
            DBUtil.closePreparedStatent(pStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getInventoryQuantity(String itemId) {
        int result = -1;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection.prepareStatement(getInventoryQuantityString);
            pStatement.setString(1, itemId);
            ResultSet resultSet = pStatement.executeQuery();
            if (resultSet.next()){
                result = resultSet.getInt(1);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatent(pStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> getItemListByProduct(String productId) {
        List<Item> itemList = new ArrayList<Item>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection.prepareStatement(getItemListByProductString);
            pStatement.setString(1, productId);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()){
                Item item = new Item();
                item.setItemId(resultSet.getString(1));
                item.setListPrice(resultSet.getBigDecimal(2));
                item.setUnitCost(resultSet.getBigDecimal(3));
                item.setSupplierId(resultSet.getInt(4));
                Product product = new Product();
                product.setProductId(resultSet.getString(5));
                product.setName(resultSet.getString(6));
                product.setDescription(resultSet.getString(7));
                product.setCategoryId(resultSet.getString(8));
                item.setProduct(product);
                item.setStatus(resultSet.getString(9));
                item.setAttribute1(resultSet.getString(10));
                item.setAttribute2(resultSet.getString(11));
                item.setAttribute3(resultSet.getString(12));
                item.setAttribute4(resultSet.getString(13));
                item.setAttribute5(resultSet.getString(14));
                itemList.add(item);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatent(pStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public Item getItem(String itemId) {
        Item item =null;
        PreparedStatement pst = null;
        //数据库结果集的数据表
        ResultSet rst = null;
        Connection cont = null;
        Statement ppst = null;
        String sql = "SELECT * FROM item WHERE itemid='"+ itemId + "'";
        try {
            cont = DBUtil.getConnection();
            ppst = cont.createStatement();
            rst = ppst.executeQuery(sql);
            while(rst.next()){
                item = new Item();
                item.setItemId(rst.getString(1));
                item.setProductId(rst.getString(2));
                item.setListPrice(rst.getBigDecimal(3));
                item.setUnitCost(rst.getBigDecimal(4));
                item.setSupplierId(rst.getInt(5));
                item.setStatus(rst.getString(6));
                item.setAttribute1(rst.getString(7));
                item.setAttribute2(rst.getString(8));
                item.setAttribute3(rst.getString(9));
                item.setAttribute4(rst.getString(10));
                item.setAttribute5(rst.getString(11));
                ProductDAO productDAO = new ProductDAOImpl();
                //根据productID设置item的product属性
                Product product=productDAO.getProduct(item.getProductId());
                item.setProduct(product);
                System.out.println("item的productId是："+item.getProduct().getProductId());


//                Product product = new Product();
//                product.setProductId(rst.getString(2));
//                product.setName(rst.getString(6));
//                product.setDescription(rst.getString(7));
//                product.setCategoryId(rst.getString(8));
//                item.setProduct(product);
//                item.setStatus(rst.getString(9));
//                item.setAttribute1(rst.getString(10));
//                item.setAttribute2(rst.getString(11));
//                item.setAttribute3(rst.getString(12));
//                item.setAttribute4(rst.getString(13));
//                item.setAttribute5(rst.getString(14));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (cont != null && ppst != null && rst != null) {
                try {
                    cont.close();
                    ppst.close();
                    rst.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return item;
//        try {
//            Connection connection = DBUtil.getConnection();
//            PreparedStatement pStatement = connection.prepareStatement(getItemString);
//            pStatement.setString(1, itemId);
//            ResultSet resultSet = pStatement.executeQuery();
//            if(resultSet.next()){
//                item = new Item();
//                item.setItemId(resultSet.getString(1));
//                item.setListPrice(resultSet.getBigDecimal(2));
//                item.setUnitCost(resultSet.getBigDecimal(3));
//                item.setSupplierId(resultSet.getInt(4));
//                Product product = new Product();
//                product.setProductId(resultSet.getString(5));
//                product.setName(resultSet.getString(6));
//                product.setDescription(resultSet.getString(7));
//                product.setCategoryId(resultSet.getString(8));
//                item.setProduct(product);
//                item.setStatus(resultSet.getString(9));
//                item.setAttribute1(resultSet.getString(10));
//                item.setAttribute2(resultSet.getString(11));
//                item.setAttribute3(resultSet.getString(12));
//                item.setAttribute4(resultSet.getString(13));
//                item.setAttribute5(resultSet.getString(14));
//            }
//            DBUtil.closeResultSet(resultSet);
//            DBUtil.closePreparedStatent(pStatement);
//            DBUtil.closeConnection(connection);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return item;
    }
}
