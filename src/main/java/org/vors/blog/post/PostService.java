package org.vors.blog.post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;
import org.vors.blog.post.domain.Post;
import org.vors.blog.post.repository.PostRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Service for finding and storing blog posts.
 */
@Component
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Post createPost(String title, String content){
        Post post = new Post();
        post.setId(UUID.randomUUID());
        post.setTitle(title);
        post.setContent(content);

        return postRepository.save(post);
    }

    public Optional<Post> findPostById(UUID id) {
        return postRepository.findById(id);
    }

    public Optional<Post> findPostByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    public Slice<Post> getAllPosts(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    public void deletePostById(UUID id) {
        postRepository.deleteById(id);
    }
}
