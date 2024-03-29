package com.ll.project_13_backend.post.dto;


import com.ll.project_13_backend.comment.entity.Comment;
import com.ll.project_13_backend.member.entity.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

   private Long id;

   @NotBlank
   private String title;
   @NotBlank
    private String content;

    private Member member;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private List<Comment> commentList; //댓글
}
