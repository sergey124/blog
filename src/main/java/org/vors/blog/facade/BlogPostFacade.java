package org.vors.blog.facade;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;
import org.vors.blog.converter.PostToDetailsConverter;
import org.vors.blog.converter.PostToInfoConverter;
import org.vors.blog.dto.PostDetails;
import org.vors.blog.dto.PostInfo;
import org.vors.blog.service.BlogPostService;

import java.util.Objects;
import java.util.Optional;

/**
 * Finds or stores blog posts, converting them between DTO and DB entities.
 */
@Component
public class BlogPostFacade {
    private BlogPostService blogPostService;
    private PostToDetailsConverter postToDetailsConverter;
    private PostToInfoConverter postToInfoConverter;

    public BlogPostFacade(
            BlogPostService blogPostService,
            PostToDetailsConverter postToDetailsConverter,
            PostToInfoConverter postToInfoConverter
    ) {
        Objects.requireNonNull(blogPostService);
        Objects.requireNonNull(postToDetailsConverter);
        Objects.requireNonNull(postToInfoConverter);
        this.blogPostService = blogPostService;
        this.postToDetailsConverter = postToDetailsConverter;
        this.postToInfoConverter = postToInfoConverter;
    }

    public Optional<PostDetails> findPostByTitle(String title) {
        return blogPostService.findPostByTitle(title)
                .map(postToDetailsConverter::convert);
    }

    public Slice<PostInfo> getPosts(Pageable pageable) {
        return blogPostService.getAllPosts(pageable)
                .map(postToInfoConverter::convert);
    }

    public PostDetails createPost(String title, String content) {
        return Optional.of(blogPostService.createPost(title, content))
                .map(postToDetailsConverter::convert)
                .orElseThrow(IllegalStateException::new);
    }
}
