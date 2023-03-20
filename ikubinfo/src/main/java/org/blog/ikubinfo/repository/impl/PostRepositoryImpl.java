package org.blog.ikubinfo.repository.impl;

import org.blog.ikubinfo.model.Post;
import org.blog.ikubinfo.repository.PostRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private static final String GET_ALL_POSTS_QUERY = "Select p from Post p";
    private static final String GET_ALL_POSTS_BY_USER_ID_QUERY = "Select p from Post p join p.user u  WHERE u.id = :id";
    @Override
    public List<Post> getAllPosts() {
        return entityManager.createQuery(GET_ALL_POSTS_QUERY,Post.class).getResultList();
    }

    @Override
    public List<Post> getPostByUserId(Integer userId) {
        return entityManager.createQuery(GET_ALL_POSTS_BY_USER_ID_QUERY,Post.class).setParameter("id",userId).getResultList();
    }

    @Override
    public Post createPost(Post post) {
         entityManager.persist(post);
         return post;
    }
}
