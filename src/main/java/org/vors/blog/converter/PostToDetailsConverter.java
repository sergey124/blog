package org.vors.blog.converter;

import org.springframework.stereotype.Component;
import org.vors.blog.data.BlogPost;
import org.vors.blog.dto.PostDetails;

@Component
public class PostToDetailsConverter {
    public PostDetails convert(BlogPost post) {
        PostDetails postData = new PostDetails();
        postData.setId(post.getId());
        postData.setTitle(post.getTitle());
        postData.setContent(post.getContent());

        return postData;
    }
}
