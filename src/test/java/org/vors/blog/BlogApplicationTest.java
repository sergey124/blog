package org.vors.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.vors.blog.config.CassandraConfig;

@SpringBootTest
@EnableAutoConfiguration(exclude = CassandraAutoConfiguration.class )
@Import(CassandraConfig.class)
class BlogApplicationTest {

	@Test
	void contextLoads() {
	}

}
