package org.vors.blog.comment.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class CommentInfo {
    private UUID postId;
    private UUID id;
    private String content;
}
