package org.vors.blog.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.vors.blog.data.BlogPost;

import java.util.Optional;

/**
 * Gets blog post entities to and from Cassandra storage.
 */
@Repository
public interface BlogPostRepository extends CassandraRepository<BlogPost, String> {
    Optional<BlogPost> findByTitle(String title);
}
