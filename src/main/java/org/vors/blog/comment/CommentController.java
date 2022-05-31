package org.vors.blog.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.vors.blog.comment.domain.dto.CommentDetails;
import org.vors.blog.comment.domain.dto.CommentInfo;

import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping(path = "posts/{postId}/comments", produces = "application/json")
@RequiredArgsConstructor
public class CommentController {

    private final CommentFacade commentFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDetails createComment(@PathVariable UUID postId, String content) {
        return commentFacade.createComment(postId, content);
    }

    @GetMapping
    public Slice<CommentInfo> getComments(@PathVariable UUID postId, Pageable pageable) {
        return commentFacade.getComments(postId, pageable);
    }

    @GetMapping(path = "/{id}")
    public CommentDetails getCommentById(@PathVariable UUID postId, @PathVariable UUID id) {
        return commentFacade.findCommentById(postId, id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find comment"));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCommentById(@PathVariable UUID postId, @PathVariable UUID id) {
        commentFacade.deleteCommentById(postId, id);
    }
}
