package org.vors.blog.domain.comment.entity.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
public class CommentDetails {
    private UUID postId;
    private UUID id;
    private LocalDateTime createdDate;
    @Size (max = 20)
    private String comment;
}
