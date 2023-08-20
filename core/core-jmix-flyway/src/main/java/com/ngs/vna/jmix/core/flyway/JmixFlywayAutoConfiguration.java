package com.ngs.vna.jmix.core.flyway;


import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@AutoConfiguration
@ConditionalOnClass({Flyway.class})
@AutoConfigureAfter({DataSourceAutoConfiguration.class})
@ConditionalOnProperty(prefix = "main.flyway", name = "enabled", matchIfMissing = true)
public class JmixFlywayAutoConfiguration {
    @Bean
    @FlywayDataSource
    public DataSource flywayDataSource(DataSource mainDataSource) {
        return mainDataSource;
    }
}
