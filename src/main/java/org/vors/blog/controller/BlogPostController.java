package org.vors.blog.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.vors.blog.dto.PostDetails;
import org.vors.blog.dto.PostInfo;
import org.vors.blog.facade.BlogPostFacade;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping(path = "posts", produces = "application/json")
public class BlogPostController {
    private BlogPostFacade blogPostFacade;

    public BlogPostController(BlogPostFacade blogPostFacade) {
        this.blogPostFacade = blogPostFacade;
    }

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public PostDetails createPost(String title, String content) {
        return blogPostFacade.createPost(title, content);
    }

    @GetMapping(path = "/{title}")
    public PostDetails findPostByTitle(@PathVariable String title) {
        return blogPostFacade.findPostByTitle(title)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));
    }

    @GetMapping
    public Slice<PostInfo> getPosts(Pageable pageable) {
        return blogPostFacade.getPosts(pageable);
    }

}
