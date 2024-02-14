package com.ll.project_13_backend.post.controller;

import com.ll.project_13_backend.post.dto.PostDto;
import com.ll.project_13_backend.post.repository.PostRepository;
import com.ll.project_13_backend.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/post")
@CrossOrigin("*")
public class PostController {

    private final PostRepository postRepository;

    private final PostService postService;
    //글 목록
    @GetMapping("/list")
    public List<PostDto> getPostList() {

        return postService.listPost();
    }

    //글 생성
    @PostMapping("/create")
    public Long creatPost(final @RequestBody PostDto postDto) {

        return postService.createPost(postDto);

    }
    //글 상세
    @GetMapping("/detail/{id}")
    public PostDto showUpdatePost(@PathVariable Long id) {

        return postService.findPost(id);
    }
    //글 수정
    @PutMapping("/modify/{id}")
    public void updatePost(@RequestBody PostDto postDto ,@PathVariable Long id) {

        postService.updatePost(postDto , id ) ;
    }
    //글 삭제
    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable Long id) {

        postService.deletePost(id);
    }

}