package org.blog.ikubinfo.service.impl;

import org.blog.ikubinfo.dto.CategoryDTO;
import org.blog.ikubinfo.exceptions.NotFoundException;
import org.blog.ikubinfo.mapper.CategoryMapper;
import org.blog.ikubinfo.model.Category;
import org.blog.ikubinfo.repository.CategoryRepository;
import org.blog.ikubinfo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static org.blog.ikubinfo.exceptions.ExceptionMessage.NOT_FOUND;
import static org.blog.ikubinfo.mapper.CategoryMapper.toDto;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getCategories() {
        return categoryRepository.getCategories().stream().map(c -> toDto(c)).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Integer id) {
        return toDto(categoryRepository.getCategoryById(id));
    }


    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        System.out.println(categoryDTO);
        return toDto(categoryRepository.addCategory(CategoryMapper.toEntity(categoryDTO)));
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        try {
            Category category = categoryRepository.getCategoryById(categoryDTO.getId());
            return toDto(categoryRepository.updateCategory(CategoryMapper.toEntityForUpdate(categoryDTO, category)));
        } catch (Exception e) {
            throw new NotFoundException(String.format(NOT_FOUND, Category.class.getSimpleName(), categoryDTO.getId()));
        }
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteCategory(categoryRepository.getCategoryById(id));
    }
}
