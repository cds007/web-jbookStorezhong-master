package org.csu.webJpetStore.domain;

import java.io.Serializable;
public class Category implements Serializable{
    //类别类
    private static final long serialVersionUID = 3992469837058393712L;

    //类别ID
    private String categoryId;
    //类别名字
    private String name;
    //类别描述
    private String description;

    public Category() {
    }

    public Category(String categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }
    /***************************************get和set方法***************************************/
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

    public String toString(){return getCategoryId();}
}
