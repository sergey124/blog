package org.vors.blog.comment.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;
import org.vors.blog.comment.domain.Comment;

import java.util.UUID;

/**
 * Gets blog post comment entities to and from Cassandra storage.
 */
@Repository
public interface CommentRepository extends CassandraRepository<Comment, Comment.Key> {
    Slice<Comment> findAllByKeyPostId(UUID postId, Pageable pageable);
}
