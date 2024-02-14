package com.ll.project_13_backend.post.service;

import com.ll.project_13_backend.global.exception.EntityNotFoundException;
import com.ll.project_13_backend.global.exception.ErrorCode;
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

    public Long createPost(final PostDto postDto ) {

        Post post = toEntity(postDto); //@service 메서드 에 선언

        Post postCreate = postRepository.save(post); // 게시글 엔티티 저장

        return postCreate.getId(); //id 값 반환
    }
    @Override
    public PostDto findPost(final Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND));

        return toDto(post); //엔티티 DTO 로 변환
    }

    @Transactional
    public void updatePost(final PostDto postDto , final Long id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND));

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

       postRepository.save(post);


    }

    @Transactional
    public void deletePost(final Long id) {

        postRepository.deleteById(id);
    }

    public List<PostDto> listPost() {

        return postRepository.findAll().stream()
                .map(post -> PostDto.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .member(post.getMember())
                        .createdDate(post.getCreatedDate())
                        .modifiedDate(post.getModifiedDate())
                        .build())
                .collect(Collectors.toList());
     }

}
