package io.avantrip.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({SwaggerConfig.class})
@EnableJpaRepositories(basePackages = "io.avantrip.repository")
@EnableTransactionManagement
public class AppConfig {
    
}