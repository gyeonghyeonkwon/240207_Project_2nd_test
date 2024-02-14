package com.ll.project_13_backend.post.controller;

import com.ll.project_13_backend.post.dto.PostDto;
import com.ll.project_13_backend.post.repository.PostRepository;
import com.ll.project_13_backend.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/post")
@CrossOrigin(origins = "*")
public class PostController {

    private final PostRepository postRepository;

    private final PostService postService;
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getPostList() {

        return postService.listPost();
    }
    //글 생성
    @PostMapping("/create")
    public Long creatPost(final @RequestBody PostDto postDto) {

        return postService.createPost(postDto);

    }

}