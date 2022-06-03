package org.vors.blog.domain.comment;

import lombok.RequiredArgsConstructor;
import org.apache.cassandra.utils.UUIDGen;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;
import org.vors.blog.domain.comment.entity.Comment;
import org.vors.blog.domain.comment.entity.repository.CommentRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment createComment(UUID postId, String content) {
        Comment comment = new Comment();
        comment.setKey(new Comment.Key(postId, UUIDGen.getTimeUUID()));
        comment.setComment(content);
        comment.setCreatedDate(LocalDateTime.now());

        return commentRepository.save(comment);
    }

    public Optional<Comment> findCommentById(UUID postId, UUID id){
        return commentRepository.findById(new Comment.Key(postId, id));
    }

    public void deleteCommentById(UUID postId, UUID id){
        commentRepository.findById(new Comment.Key(postId, id))
                .ifPresent(commentRepository::delete);
    }

    public Slice<Comment> getComments(UUID postId, Pageable pageable) {
        return commentRepository.findAllByKeyPostId(postId, pageable);
    }
}
