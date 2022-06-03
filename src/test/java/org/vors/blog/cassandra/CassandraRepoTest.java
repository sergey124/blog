package org.vors.blog.cassandra;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.vors.blog.config.CassandraConfig;
import org.vors.blog.domain.post.entity.Post;
import org.vors.blog.domain.post.entity.repository.PostRepository;

import java.util.UUID;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = CassandraAutoConfiguration.class)
@Import(CassandraConfig.class)
public class CassandraRepoTest {
    private static final String TITLE = "Some title";
    private static final String CONTENT = "# header\n Text.";
    private static final UUID ID = UUID.randomUUID();

    @Autowired
    private PostRepository postRepository;

    @Test
    public void fetchGivenPostFromStorage() {
        createAndStorePost();

        Post foundPost = postRepository.findById(ID)
                .orElseThrow(IllegalStateException::new);

        Assert.assertEquals(ID, foundPost.getId());
        Assert.assertEquals(TITLE, foundPost.getTitle());
        Assert.assertEquals(CONTENT, foundPost.getContent());
    }

    private void createAndStorePost() {
        Post post = new Post();

        post.setId(ID);
        post.setTitle(TITLE);
        post.setContent(CONTENT);

        postRepository.save(post);
    }
}
