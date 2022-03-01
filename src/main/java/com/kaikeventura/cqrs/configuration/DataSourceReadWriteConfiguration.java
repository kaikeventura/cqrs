package com.kaikeventura.cqrs.configuration;

import com.kaikeventura.cqrs.annotation.ReadOnlyRepository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

import static com.kaikeventura.cqrs.CqrsApplication.JPA_PROPERTIES;
import static com.kaikeventura.cqrs.CqrsApplication.MODEL_PACKAGE;

@Configuration
@ConfigurationProperties("spring.datasource-write")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryWrite",
        basePackages = "com.kaikeventura.cqrs.repository.write",
        transactionManagerRef = "transactionManagerWrite",
        excludeFilters = @ComponentScan.Filter(ReadOnlyRepository.class)
)
public class DataSourceReadWriteConfiguration extends HikariConfig {

    public final static String PERSISTENCE_UNIT_NAME = "write";

    @Bean
    public HikariDataSource dataSourceWrite() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryWrite(
            final HikariDataSource dataSourceWrite
    ) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSourceWrite);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_PROPERTIES);
        }};
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManagerWrite(EntityManagerFactory entityManagerFactoryWrite) {
        return new JpaTransactionManager(entityManagerFactoryWrite);
    }
}
