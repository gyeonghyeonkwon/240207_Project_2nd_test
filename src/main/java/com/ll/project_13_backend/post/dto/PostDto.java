package com.ll.project_13_backend.post.dto;


import com.ll.project_13_backend.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

   private Long id;

    private String title;

    private String content;

    private Member member;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;
}
