package org.vors.blog.domain.comment.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
public class NewCommentRequest {
    @JsonProperty
    @NotEmpty(message = "comment is required")
    @Size(max = 20)
    private String comment;
}
