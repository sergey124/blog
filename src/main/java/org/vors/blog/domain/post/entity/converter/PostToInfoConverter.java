package org.vors.blog.domain.post.entity.converter;

import org.vors.blog.domain.post.entity.Post;
import org.vors.blog.domain.post.entity.dto.PostInfo;
import org.springframework.stereotype.Component;


@Component
public class PostToInfoConverter {
    public PostInfo convert(Post post) {
        PostInfo postData = new PostInfo();
        postData.setId(post.getId());
        postData.setTitle(post.getTitle());

        return postData;
    }
}
