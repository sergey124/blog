package org.vors.blog.domain.comment.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class CommentInfo {
    private UUID postId;
    private UUID id;
    private String comment;
}
