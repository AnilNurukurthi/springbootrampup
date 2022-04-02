package com.boot.tutserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.boot.tutserver")
@EntityScan("com.boot.tutserver")
@SpringBootApplication
public class SpringbootTutApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTutApplication.class, args);
    }
}

