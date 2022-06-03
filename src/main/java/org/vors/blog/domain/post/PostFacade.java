package org.vors.blog.domain.post;

import org.vors.blog.domain.post.entity.converter.PostToDetailsConverter;
import org.vors.blog.domain.post.entity.converter.PostToInfoConverter;
import org.vors.blog.domain.post.entity.dto.PostDetails;
import org.vors.blog.domain.post.entity.dto.PostInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;


/**
 * Finds or stores blog posts, converting them between DTO and DB entities.
 */
@Component
@RequiredArgsConstructor
public class PostFacade {
    private final PostService postService;
    private final PostToDetailsConverter postToDetailsConverter;
    private final PostToInfoConverter postToInfoConverter;

    public Optional<PostDetails> findPostById(UUID id) {
        return postService.findPostById(id)
                .map(postToDetailsConverter::convert);
    }

    public Optional<PostDetails> findPostByTitle(String title) {
        return postService.findPostByTitle(title)
                .map(postToDetailsConverter::convert);
    }

    public void deletePostById(UUID id) {
        postService.deletePostById(id);
    }


    public Slice<PostInfo> getPosts(Pageable pageable) {
        return postService.getAllPosts(pageable)
                .map(postToInfoConverter::convert);
    }

    public PostDetails createPost(String title, String content) {
        return Optional.of(postService.createPost(title, content))
                .map(postToDetailsConverter::convert)
                .orElseThrow(IllegalStateException::new);
    }
}
