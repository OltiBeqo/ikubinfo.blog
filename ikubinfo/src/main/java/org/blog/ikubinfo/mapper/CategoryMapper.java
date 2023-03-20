package org.blog.ikubinfo.mapper;

import org.blog.ikubinfo.dto.CategoryDTO;
import org.blog.ikubinfo.model.Category;

import java.time.LocalDateTime;

public class CategoryMapper {

    public static CategoryDTO toDto(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category toEntity(CategoryDTO categoryDTO){
        return Category.builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .dateCreated(LocalDateTime.now())
                .build();
    }
    public static Category toEntityForUpdate(CategoryDTO categoryDTO, Category category){
        category.setName(categoryDTO.getName());
        category.setDateModified(LocalDateTime.now());

        return category;
    }
}
