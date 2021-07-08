package com.validus.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.validus.repositories")
@EntityScan(basePackages = "com.validus.domain")
@ComponentScan(value = "com.validus")

public class MusicdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicdbApplication.class, args);
    }
}
