package org.blog.ikubinfo.repository;

import org.blog.ikubinfo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository {

    List<Post> getAllPosts();

    List<Post> getPostByUserId(Integer userId);
    Post createPost(Post post);


}
