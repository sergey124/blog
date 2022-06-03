package org.vors.blog.domain.post.entity.converter;

import org.vors.blog.domain.post.entity.Post;
import org.vors.blog.domain.post.entity.dto.PostDetails;
import org.springframework.stereotype.Component;


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
