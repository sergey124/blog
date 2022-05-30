package org.vors.blog.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.vors.blog.dto.PostData;
import org.vors.blog.facade.BlogPostFacade;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping(path = "posts", produces = "application/json")
public class BlogPostController {
    private BlogPostFacade blogPostFacade;

    public BlogPostController(BlogPostFacade blogPostFacade) {
        this.blogPostFacade = blogPostFacade;
    }

    @PostMapping(path = "/create")
    public void createPost(String title, String content) {
        blogPostFacade.saveBlogPost(title, content);
    }

    @GetMapping(path = "/{title}")
    public PostData findPostByTitle(@PathVariable String title) {
        return blogPostFacade.findPostByTitle(title)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));
    }

    @GetMapping
    public List<PostData> getAllPosts() {
        return Collections.emptyList();
    }

}
