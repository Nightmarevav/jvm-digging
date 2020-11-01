package ru.petrelevich.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    //@Primary
    @Bean(name = "demoDbDataSource")
    @ConfigurationProperties("app.datasource.demo-db")
    public DataSource demoDbDataSource() {
        return DataSourceBuilder.create().build();
    }
}
