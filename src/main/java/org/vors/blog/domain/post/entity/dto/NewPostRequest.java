package org.vors.blog.domain.post.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
public class NewPostRequest {
    @JsonProperty
    @NotEmpty(message = "title is required")
    @Size(max = 20)
    private String title;

    @JsonProperty
    @NotEmpty(message = "content is required")
    private String content;
}
