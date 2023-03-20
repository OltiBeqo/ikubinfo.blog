package org.blog.ikubinfo.mapper;

import org.blog.ikubinfo.dto.PostDTO;
import org.blog.ikubinfo.model.Post;

import java.util.stream.Collectors;

public class PostMapper {

    public static PostDTO toDto(Post post){
        return PostDTO.builder()
                .id(post.getId())
                .body(post.getBody())
                .title(post.getTitle())
                .user(UserMapper.toDto(post.getUser()))
                .postCategories(post.getPostCategoryList().stream().map(pc -> PostCategoryMapper.toDto(pc)).collect(Collectors.toList()))
                .build();
    }


    public static Post toEntity(PostDTO postDTO){
        return Post.builder()
                .id(postDTO.getId())
                .body(postDTO.getBody())
                .title(postDTO.getTitle())
                .build();
    }
}
