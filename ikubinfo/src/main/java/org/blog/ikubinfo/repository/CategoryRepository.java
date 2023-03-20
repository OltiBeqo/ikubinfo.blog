package org.blog.ikubinfo.repository;

import org.blog.ikubinfo.model.Category;

import java.util.List;

public interface CategoryRepository {

    List<Category> getCategories();
    Category getCategoryById(Integer id);
    Category addCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Category category);

}
