package org.vors.blog.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;
import org.vors.blog.domain.comment.entity.converter.CommentToCommentDetailsConverter;
import org.vors.blog.domain.comment.entity.converter.CommentToCommentInfoConverter;
import org.vors.blog.domain.comment.entity.dto.CommentDetails;
import org.vors.blog.domain.comment.entity.dto.CommentInfo;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CommentFacade {
    private final CommentService commentService;
    private final CommentToCommentDetailsConverter commentToDetailsConverter;
    private final CommentToCommentInfoConverter commentToCommentInfoConverter;

    public CommentDetails createComment(UUID postId, String content) {
        return Optional.of(commentService.createComment(postId, content))
                .map(commentToDetailsConverter::convert)
                .orElseThrow(IllegalStateException::new);
    }

    public Slice<CommentInfo> getComments(UUID postId, Pageable pageable){
        return commentService.getComments(postId, pageable)
                .map(commentToCommentInfoConverter::convert);
    }

    public Optional<CommentDetails> findCommentById(UUID postId, UUID id){
        return commentService.findCommentById(postId, id)
                .map(commentToDetailsConverter::convert);
    }

    public void deleteCommentById(UUID postId, UUID id){
        commentService.deleteCommentById(postId, id);
    }
}
