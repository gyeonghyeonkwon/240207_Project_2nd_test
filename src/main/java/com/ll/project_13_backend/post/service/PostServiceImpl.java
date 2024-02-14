package com.ll.project_13_backend.post.service;

import com.ll.project_13_backend.post.dto.PostDto;
import com.ll.project_13_backend.post.entity.Post;
import com.ll.project_13_backend.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    @Transactional
    public Long createPost(final PostDto postDto) {

        Post post = toEntity(postDto); //@service 메서드 에 선언

        Post postCreate = postRepository.save(post); // 게시글 엔티티 저장

        return postCreate.getId(); //id 값 반환
    }
    @Override
    public PostDto findPost(final Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("글을 찾을수 없다."));

        return toDto(post); //엔티티 DTO 로 변환
    }

    @Transactional
    public void updatePost(final PostDto postDto) {

        Post post = postRepository.findById(postDto.getId())
                .orElseThrow(() -> new RuntimeException("글을 찾을수 없다."));

        post.setTitle(post.getTitle());
        post.setContent(post.getContent());

        postRepository.save(post);

    }

    @Transactional
    public void deletePost(final Long postId) {

        postRepository.deleteById(postId);
    }

    public List<PostDto> listPost() {

        return postRepository.findAll().stream()
                .map(post -> PostDto.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .createdDate(post.getCreatedDate())
                        .modifiedDate(post.getModifiedDate())
                        .build())
                .collect(Collectors.toList());
     }

}
