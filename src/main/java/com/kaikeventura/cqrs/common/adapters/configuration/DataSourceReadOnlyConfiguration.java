package com.kaikeventura.cqrs.common.adapters.configuration;

import com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.annotation.ReadOnlyRepository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

import static com.kaikeventura.cqrs.CqrsApplication.JPA_PROPERTIES;
import static com.kaikeventura.cqrs.CqrsApplication.MODEL_PACKAGE;

@Configuration
@ConfigurationProperties("spring.datasource-read")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryRead",
        basePackages = "com.kaikeventura.cqrs.product.adapters.outbound.persistence.repository.read",
        transactionManagerRef = "transactionManagerRead",
        includeFilters = @ComponentScan.Filter(ReadOnlyRepository.class)
)
public class DataSourceReadOnlyConfiguration extends HikariConfig {

    public final static String PERSISTENCE_UNIT_NAME = "read";

    @Bean
    public HikariDataSource dataSourceRead() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryRead(
            final HikariDataSource dataSourceRead
    ) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSourceRead);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_PROPERTIES);
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerRead(EntityManagerFactory entityManagerFactoryRead) {
        return new JpaTransactionManager(entityManagerFactoryRead);
    }
}
