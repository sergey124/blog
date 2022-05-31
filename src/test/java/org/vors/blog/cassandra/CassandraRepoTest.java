package org.vors.blog.cassandra;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.vors.blog.config.CassandraConfig;
import org.vors.blog.post.domain.Post;
import org.vors.blog.post.repository.PostRepository;

import java.util.Optional;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = CassandraAutoConfiguration.class )
@Import(CassandraConfig.class)
public class CassandraRepoTest {
    public static final String TITLE = "Hello world";
    public static final String CONTENT = "# header\n Text.";

    @Autowired
    private PostRepository postRepository;

    @Test
    public void test() {
        Post post = new Post();
        post.setId(UUID.randomUUID());
        post.setTitle("Hello world");
        post.setContent(CONTENT);

        postRepository.save(post);

        Optional<Post> foundPostOpt = postRepository.findByTitle(TITLE);

        Assert.assertTrue(foundPostOpt.isPresent());
        Post foundPost = foundPostOpt.get();
        Assert.assertEquals(TITLE, foundPost.getTitle());
        Assert.assertEquals(CONTENT, foundPost.getContent());
    }
}
