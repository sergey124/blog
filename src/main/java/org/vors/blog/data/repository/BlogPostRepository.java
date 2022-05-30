package org.vors.blog.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.vors.blog.data.BlogPost;

import java.util.Optional;
import java.util.UUID;

/**
 * Gets blog post entities to and from Cassandra storage.
 */
@Repository
public interface BlogPostRepository extends CassandraRepository<BlogPost, UUID> {
    Optional<BlogPost> findByTitle(String title);
}
