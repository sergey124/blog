package org.vors.blog.converter;

import org.springframework.stereotype.Component;
import org.vors.blog.data.BlogPost;
import org.vors.blog.dto.PostData;

@Component
public class BlogPostConverter {
    public PostData convert(BlogPost post) {
        PostData postData = new PostData();
        postData.setId(post.getId());
        postData.setTitle(post.getTitle());
        postData.setContent(post.getContent());

        return postData;
    }
}
