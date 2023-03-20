package org.blog.ikubinfo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.blog.ikubinfo.model.Post;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder @JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Integer id ;

    private String email;

    private List<PostDTO> post;

    private String username;

}
