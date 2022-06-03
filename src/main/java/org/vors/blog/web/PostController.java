package org.vors.blog.web;

import org.vors.blog.domain.post.PostFacade;
import org.vors.blog.domain.post.entity.dto.NewPostRequest;
import org.vors.blog.domain.post.entity.dto.PostDetails;
import org.vors.blog.domain.post.entity.dto.PostInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@RestController
@RequestMapping(path = "posts", produces = "application/json")
@RequiredArgsConstructor
public class PostController {
    private final PostFacade postFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDetails createPost(@RequestBody @Valid NewPostRequest newPost) {
        return postFacade.createPost(newPost.getTitle(), newPost.getContent());
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
