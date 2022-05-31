package org.vors.blog.post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.vors.blog.post.domain.dto.PostDetails;
import org.vors.blog.post.domain.dto.PostInfo;

import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping(path = "posts", produces = "application/json")
public class PostController {
    private PostFacade postFacade;

    public PostController(PostFacade postFacade) {
        this.postFacade = postFacade;
    }

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public PostDetails createPost(String title, String content) {
        return postFacade.createPost(title, content);
    }

    @GetMapping(path = "/{id}")
    public PostDetails getPostById(@PathVariable UUID id) {
        return postFacade.findPostById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));
    }

    @GetMapping(path = "/find")
    public PostDetails findPostByTitle(@RequestParam String title) {
        return postFacade.findPostByTitle(title)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));
    }

    @DeleteMapping(path = "/{id}")
    public void deletePostById(@PathVariable UUID id) {
        postFacade.deletePostById(id);
    }

    @GetMapping
    public Slice<PostInfo> getPosts(Pageable pageable) {
        return postFacade.getPosts(pageable);
    }
}
