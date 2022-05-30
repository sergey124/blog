package org.vors.blog.converter;

import org.springframework.stereotype.Component;
import org.vors.blog.data.BlogPost;
import org.vors.blog.dto.PostInfo;

@Component
public class PostToInfoConverter {
    public PostInfo convert(BlogPost post) {
        PostInfo postData = new PostInfo();
        postData.setId(post.getId());
        postData.setTitle(post.getTitle());

        return postData;
    }
}
