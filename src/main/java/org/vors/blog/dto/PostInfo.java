package org.vors.blog.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class PostInfo {
    private UUID id;
    private String title;
}
