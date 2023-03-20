package org.blog.ikubinfo.repository.impl;

import org.blog.ikubinfo.model.Category;
import org.blog.ikubinfo.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public static final String GET_CATEGORIES = "select c from Category c";
    public static final String GET_CATEGORY_BY_ID = "select c from Category c where c.id = :id";

    @Override
    public List<Category> getCategories() {
        TypedQuery<Category> categoryTypedQuery = entityManager.createQuery(GET_CATEGORIES,Category.class);
        return categoryTypedQuery.getResultList();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return entityManager.createQuery(GET_CATEGORY_BY_ID, Category.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    @Override
    public Category addCategory(Category category) {
        entityManager.persist(category);
        return category;
    }
    @Override
    public Category updateCategory(Category category) {
        return entityManager.merge(category);
    }
    @Override
    public void deleteCategory(Category category) {
        entityManager.remove(category);
    }
}
