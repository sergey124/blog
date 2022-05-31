package org.vors.blog.post.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.vors.blog.post.domain.Post;

import java.util.Optional;
import java.util.UUID;

/**
 * Gets blog post entities to and from Cassandra storage.
 */
@Repository
public interface PostRepository extends CassandraRepository<Post, UUID> {
    Optional<Post> findByTitle(String title);
}
