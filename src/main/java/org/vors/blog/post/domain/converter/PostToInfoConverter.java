package org.vors.blog.post.domain.converter;

import org.springframework.stereotype.Component;
import org.vors.blog.post.domain.Post;
import org.vors.blog.post.domain.dto.PostInfo;

@Component
public class PostToInfoConverter {
    public PostInfo convert(Post post) {
        PostInfo postData = new PostInfo();
        postData.setId(post.getId());
        postData.setTitle(post.getTitle());

        return postData;
    }
}
