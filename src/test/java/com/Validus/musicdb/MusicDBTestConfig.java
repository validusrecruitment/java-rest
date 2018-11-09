package com.validus.musicdb;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan(value = "com.validus")
@EnableJpaRepositories(basePackages = "com.validus.repositories")
@EntityScan(basePackages = "com.validus.domain")
public class MusicDBTestConfig {

}
