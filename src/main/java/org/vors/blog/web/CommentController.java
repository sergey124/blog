package org.vors.blog.web;

import org.vors.blog.domain.comment.CommentFacade;
import org.vors.blog.domain.comment.entity.dto.CommentDetails;
import org.vors.blog.domain.comment.entity.dto.CommentInfo;
import org.vors.blog.domain.comment.entity.dto.NewCommentRequest;
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
@RequestMapping(path = "posts/{postId}/comments", produces = "application/json")
@RequiredArgsConstructor
public class CommentController {

    private final CommentFacade commentFacade;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDetails createComment(
            @PathVariable UUID postId,
            @RequestBody @Valid NewCommentRequest newComment) {
        return commentFacade.createComment(postId, newComment.getComment());
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
