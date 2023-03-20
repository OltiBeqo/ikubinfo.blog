package org.blog.ikubinfo.controller;

import org.apache.coyote.Response;
import org.blog.ikubinfo.dto.PostDTO;
import org.blog.ikubinfo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(postService.createPost(postDTO));
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/user")
    public ResponseEntity<List<PostDTO>> getPostsByUserId(@RequestParam Integer userId){
        return ResponseEntity.ok(postService.getPostByUserId(userId));
    }
}
