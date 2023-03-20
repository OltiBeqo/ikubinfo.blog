package org.blog.ikubinfo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.blog.ikubinfo.model.Category;
import org.blog.ikubinfo.model.Post;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder @JsonInclude(JsonInclude.Include.NON_NULL)
public class PostCategoryDTO {
    private Integer id;

    private PostDTO pos;

    private CategoryDTO category;

}
