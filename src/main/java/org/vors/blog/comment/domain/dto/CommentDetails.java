package org.vors.blog.comment.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
public class CommentDetails {
    private UUID postId;
    private UUID id;
    private LocalDateTime createdDate;
    private String content;
}
