package org.vors.blog.service;

import org.springframework.stereotype.Component;
import org.vors.blog.data.BlogPost;
import org.vors.blog.data.repository.BlogPostRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service for finding and storing blog posts.
 */
@Component
public class BlogPostService {
    private BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository){
        this.blogPostRepository = blogPostRepository;
    }

    public void saveBlogPost(String title, String content){
        BlogPost post = new BlogPost();
        post.setId(UUID.randomUUID());
        post.setTitle(title);
        post.setContent(content);

        blogPostRepository.save(post);
    }

    public Optional<BlogPost> findPostByTitle(String title) {
        return blogPostRepository.findByTitle(title);
    }

    public List<BlogPost> getAllPosts(){
        return blogPostRepository.findAll();
    }
}
