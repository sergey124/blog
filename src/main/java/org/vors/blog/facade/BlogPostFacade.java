package org.vors.blog.facade;

import org.springframework.stereotype.Component;
import org.vors.blog.converter.BlogPostConverter;
import org.vors.blog.dto.PostData;
import org.vors.blog.service.BlogPostService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Finds or stores blog posts, converting them between DTO and DB entities.
 */
@Component
public class BlogPostFacade {
    private BlogPostService blogPostService;
    private BlogPostConverter blogPostConverter;

    public BlogPostFacade(
            BlogPostService blogPostService,
            BlogPostConverter blogPostConverter) {
        Objects.requireNonNull(blogPostService);
        Objects.requireNonNull(blogPostConverter);
        this.blogPostService = blogPostService;
        this.blogPostConverter = blogPostConverter;
    }

    public Optional<PostData> findPostByTitle(String title) {
        return blogPostService.findPostByTitle(title)
                .map(blogPostConverter::convert);
    }

    public List<PostData> getPosts(){
        return blogPostService.getAllPosts().stream()
                .map(blogPostConverter::convert)
                .collect(Collectors.toList());
    }

    public void saveBlogPost(String title, String content) {
        blogPostService.saveBlogPost(title, content);
    }
}
