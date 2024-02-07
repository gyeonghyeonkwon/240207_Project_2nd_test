package com.ll.project_13_backend.post.controller;

import com.ll.project_13_backend.post.entity.Post;
import com.ll.project_13_backend.post.repository.PostRepository;
import com.ll.project_13_backend.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/post")
@CrossOrigin(origins = "*")
public class PostController {

    private final PostRepository postRepository;

    private final PostService postService;
    @GetMapping("/list")
    public List<Post> getPostList() {

        return postRepository.findAll();
    }

}