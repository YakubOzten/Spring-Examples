package com.yakubozten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories()
public class SpringElecticsearchApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringElecticsearchApplication.class, args);
    }

}
