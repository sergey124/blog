package org.vors.blog.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.CassandraUnitTestExecutionListener;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ CassandraUnitTestExecutionListener.class })
@CassandraDataSet(value = { "create_tables.cql" })
@EmbeddedCassandra
public class SpringCQLScriptLoadTest {

    @Test
    public void should_have_started_and_execute_cql_script() throws Exception {
        CqlSession session = EmbeddedCassandraServerHelper.getSession();

        ResultSet result = session.execute("select * from blogpost WHERE title='First post'");
        assertThat(result.iterator().next().getString("content"), is("Some content"));
    }
}
