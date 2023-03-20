package org.blog.ikubinfo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString @JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {

    private Integer id;
    @NotBlank
    @NotNull
    private String name;
    private List<PostCategoryDTO> categoryPosts;




}
