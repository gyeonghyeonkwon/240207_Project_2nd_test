package com.ll.project_13_backend.post.service;

import com.ll.project_13_backend.member.entity.Member;
import com.ll.project_13_backend.post.entity.Post;
import com.ll.project_13_backend.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    @Transactional
    public void createPost(final String title , final String content , final Member member) {

        Post post = Post.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
        this.postRepository.save(post);
    }

    public void findPost(final Long postId) {

    }

    public void updatePost(final Long postId, final Post post, final Member member) {

    }

    public void deletePost(final Long postId, final Member member) {

    }

}
