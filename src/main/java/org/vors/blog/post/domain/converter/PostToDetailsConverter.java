package org.vors.blog.post.domain.converter;

import org.springframework.stereotype.Component;
import org.vors.blog.post.domain.Post;
import org.vors.blog.post.domain.dto.PostDetails;

@Component
public class PostToDetailsConverter {
    public PostDetails convert(Post post) {
        PostDetails postData = new PostDetails();
        postData.setId(post.getId());
        postData.setTitle(post.getTitle());
        postData.setContent(post.getContent());

        return postData;
    }
}
