package org.blog.ikubinfo.repository;

import org.blog.ikubinfo.model.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCategoryRepository extends JpaRepository<PostCategory,Integer> {
}
