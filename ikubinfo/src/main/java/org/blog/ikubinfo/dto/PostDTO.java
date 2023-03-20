package org.blog.ikubinfo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.blog.ikubinfo.model.Category;
import org.blog.ikubinfo.model.PostCategory;
import org.blog.ikubinfo.model.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO {
    private Integer id;

    private String body;

    private String title;

    private List<PostCategoryDTO> postCategories;

    private UserDTO user;


}
