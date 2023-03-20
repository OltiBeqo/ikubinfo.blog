package org.blog.ikubinfo.service.impl;

import org.blog.ikubinfo.dto.PostCategoryDTO;
import org.blog.ikubinfo.dto.PostDTO;
import org.blog.ikubinfo.exceptions.ExceptionMessage;
import org.blog.ikubinfo.exceptions.NotFoundException;
import org.blog.ikubinfo.mapper.PostMapper;
import org.blog.ikubinfo.model.Category;
import org.blog.ikubinfo.model.Post;
import org.blog.ikubinfo.model.PostCategory;
import org.blog.ikubinfo.repository.CategoryRepository;
import org.blog.ikubinfo.repository.PostCategoryRepository;
import org.blog.ikubinfo.repository.PostRepository;
import org.blog.ikubinfo.repository.UserRepository;
import org.blog.ikubinfo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.blog.ikubinfo.mapper.PostMapper.toDto;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PostCategoryRepository postCategoryRepository;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.getAllPosts().stream().map(PostMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> getPostByUserId(Integer userId) {
        return postRepository.getPostByUserId(userId).stream().map(PostMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        List<Category> categoryList = new ArrayList<>();

        for (PostCategoryDTO postCategory : postDTO.getPostCategories()) {
            Integer categoryId = postCategory.getCategory().getId();
            categoryList.add(categoryRepository.getCategoryById(categoryId));
        }


        Post post = PostMapper.toEntity(postDTO);
        post.setUser(userRepository.findById(postDTO.getUser().getId())
                .orElseThrow(() -> new NotFoundException(String.format(ExceptionMessage.NOT_FOUND, "User", postDTO.getUser().getId()))));

        postRepository.createPost(post);

        for (Category category : categoryList) {
            PostCategory postCategory = new PostCategory();
            postCategory.setPost(post);
            postCategory.setCategory(category);
            postCategory.setDateCreated(LocalDateTime.now());
            postCategoryRepository.save(postCategory);
        }
        return toDto(post);

    }
}
