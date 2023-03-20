package org.blog.ikubinfo.mapper;

import org.blog.ikubinfo.dto.PostCategoryDTO;
import org.blog.ikubinfo.model.PostCategory;

public class PostCategoryMapper {
    public static PostCategoryDTO toDto(PostCategory postCategory) {
        PostCategoryDTO postCategoryDTO = new PostCategoryDTO();
        postCategoryDTO.setCategory(CategoryMapper.toDto(postCategory.getCategory()));
        return postCategoryDTO;
    }
}
