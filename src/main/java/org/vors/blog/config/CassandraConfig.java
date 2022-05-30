package org.vors.blog.config;

import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.cassandra.SessionFactory;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraEntityClassScanner;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.core.cql.session.init.ResourceKeyspacePopulator;
import org.springframework.data.cassandra.core.cql.session.init.SessionFactoryInitializer;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Configuration
@EnableCassandraRepositories(basePackages = "org.vors.blog.data.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {
    public static final String CASSANDRA_ENTITY_PACKAGE = "org.vors.blog.data";
    @Value("${spring.data.cassandra.keyspace-name}")
    public String keyspace;
    @Value("${spring.data.cassandra.port}")
    private int port;

    public CassandraConfig () throws IOException {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra("cassandra.yaml");
    }

    @Bean
    public CassandraMappingContext cassandraMapping() {
        return new CassandraMappingContext();
    }

    @Bean
    SessionFactoryInitializer sessionFactoryInitializer(SessionFactory sessionFactory) {
        SessionFactoryInitializer initializer = new SessionFactoryInitializer();
        initializer.setSessionFactory(sessionFactory);

        ResourceKeyspacePopulator populator = new ResourceKeyspacePopulator();
        populator.setSeparator(";");
        populator.setScripts(new ClassPathResource("create_tables.cql"));

        initializer.setKeyspacePopulator(populator);

        return initializer;
    }

    @Override
    protected String getKeyspaceName() {
        return keyspace;
    }

    /*
     * Automatically creates a Keyspace if it doesn't exist
     */
    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification
                .createKeyspace(keyspace).ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true).withSimpleReplication();
        return Arrays.asList(specification);
    }

    /*
     * Automatically configure a table if doesn't exist
     */
    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{CASSANDRA_ENTITY_PACKAGE};
    }

    @Override
    protected Set<Class<?>> getInitialEntitySet() throws ClassNotFoundException {
        return CassandraEntityClassScanner.scan(getEntityBasePackages());
    }

    @Override
    protected int getPort(){
        return port;
    }
}