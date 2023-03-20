package org.blog.ikubinfo.service;

import org.blog.ikubinfo.dto.CategoryDTO;
import org.blog.ikubinfo.model.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getCategories();
    CategoryDTO getCategoryById(Integer id);
    CategoryDTO addCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(CategoryDTO categoryDTO);
    void deleteCategory(Integer id);
}
