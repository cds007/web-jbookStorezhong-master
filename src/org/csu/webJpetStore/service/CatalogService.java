package org.csu.webJpetStore.service;

import org.csu.webJpetStore.domain.Category;
import org.csu.webJpetStore.domain.Item;
import org.csu.webJpetStore.domain.Product;
import org.csu.webJpetStore.persistence.CategoryDAO;
import org.csu.webJpetStore.persistence.Impl.CategoryDAOImpl;
import org.csu.webJpetStore.persistence.Impl.ItemDAOImpl;
import org.csu.webJpetStore.persistence.Impl.ProductDAOImpl;
import org.csu.webJpetStore.persistence.ItemDAO;
import org.csu.webJpetStore.persistence.ProductDAO;

import java.util.List;

public class CatalogService {
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private ItemDAO itemDAO;


    public CatalogService(){
        categoryDAO = new CategoryDAOImpl();
        productDAO = new ProductDAOImpl();
        itemDAO = new ItemDAOImpl();
    }

    public List<Category> getCategoryList() {

        return categoryDAO.getCategoryList();
    }

    public Category getCategory(String categoryId) {

        return categoryDAO.getCategory(categoryId);
    }

    public Product getProduct(String productId) {
        return productDAO.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productDAO.getProductListByCategory(categoryId);
    }

    /* TODO enable using more than one keyword*/
    public List<Product> searchProductList(String keyword) {
        return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    public List<Item> getItemListByProduct(String productId) {
        return itemDAO.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) {
        return itemDAO.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) {
        return itemDAO.getInventoryQuantity(itemId) > 0;
    }
}
