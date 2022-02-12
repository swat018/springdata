package com.example.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories
@Import(JinwooRegistrar.class)
public class SpringdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdataApplication.class, args);
    }

}
