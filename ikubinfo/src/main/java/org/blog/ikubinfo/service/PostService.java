package org.blog.ikubinfo.service;

import org.blog.ikubinfo.dto.PostDTO;
import org.blog.ikubinfo.model.Post;

import java.util.List;

public interface PostService {
    List<PostDTO> getAllPosts();

    List<PostDTO> getPostByUserId(Integer userId);
    PostDTO createPost(PostDTO postDTO);
}
