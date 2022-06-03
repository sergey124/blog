package org.vors.blog.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.CassandraUnitTestExecutionListener;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Disabled // conflicts. Example that boots up Cassandra in another way than real config used by other tests
@ExtendWith(SpringExtension.class)
@TestExecutionListeners({ CassandraUnitTestExecutionListener.class })
@CassandraDataSet(value = { "create_tables.cql" })
@EmbeddedCassandra
public class SpringCQLScriptLoadTest {

    @Test
    public void should_have_started_and_execute_cql_script() {
        CqlSession session = EmbeddedCassandraServerHelper.getSession();

        ResultSet result = session.execute("select * from post WHERE id = e8546746-6b83-42cf-9386-0ce602f16d7a");
        assertThat(result.iterator().next().getString("content"), is("Some content"));
    }
}
