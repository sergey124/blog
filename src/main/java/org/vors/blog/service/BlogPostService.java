package org.vors.blog.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;
import org.vors.blog.data.BlogPost;
import org.vors.blog.data.repository.BlogPostRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Service for finding and storing blog posts.
 */
@Component
public class BlogPostService {
    public static final int PAGE_SIZE = 10;
    private BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository){
        this.blogPostRepository = blogPostRepository;
    }

    public BlogPost createPost(String title, String content){
        BlogPost post = new BlogPost();
        post.setId(UUID.randomUUID());
        post.setTitle(title);
        post.setContent(content);

        return blogPostRepository.save(post);
    }

    public Optional<BlogPost> findPostByTitle(String title) {
        return blogPostRepository.findByTitle(title);
    }

    public Slice<BlogPost> getAllPosts(Pageable pageable){
        return blogPostRepository.findAll(pageable);
    }
}
