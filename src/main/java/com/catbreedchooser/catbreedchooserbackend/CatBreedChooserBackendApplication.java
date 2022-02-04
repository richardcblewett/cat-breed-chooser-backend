package com.catbreedchooser.catbreedchooserbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CatBreedChooserBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatBreedChooserBackendApplication.class, args);
    }

}
