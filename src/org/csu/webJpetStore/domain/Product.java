package org.csu.webJpetStore.domain;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = -7492639752670189553L;

    //产品ID
    private String productId;
    //类别ID
    private String categoryId;
    //产品名称
    private String name;
    //产品描述
    private String description;

    public Product() {
    }

    public Product(String productId, String categoryId, String name, String description) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
