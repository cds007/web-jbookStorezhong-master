package org.csu.webJpetStore.persistence;

import org.csu.webJpetStore.domain.Category;

import java.util.List;

public interface CategoryDAO {
    //获取所有的大类  select All categories
    List<Category> getCategoryList();

    //通过id查看某一个类  select a category by ID
    Category getCategory(String categoryId);
}
