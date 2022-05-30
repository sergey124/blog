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
import org.vors.blog.data.BlogPost;
import org.vors.blog.data.repository.BlogPostRepository;

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
    private BlogPostRepository blogPostRepository;

    @Test
    public void test() {
        BlogPost post = new BlogPost();
        post.setId(UUID.randomUUID());
        post.setTitle("Hello world");
        post.setContent(CONTENT);

        blogPostRepository.save(post);

        Optional<BlogPost> foundPostOpt = blogPostRepository.findByTitle(TITLE);

        Assert.assertTrue(foundPostOpt.isPresent());
        BlogPost foundPost = foundPostOpt.get();
        Assert.assertEquals(TITLE, foundPost.getTitle());
        Assert.assertEquals(CONTENT, foundPost.getContent());
    }
}
