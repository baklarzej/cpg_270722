package com.pivovarit.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 1. Stworzyć serwis "movie-descriptions" wystawiający API HTTP GET /descriptions/{id} i odpowiadający JSON {"description": "cośtam"}
// 2. Niech Rental Store zwraca w MovieDto dodatkowe pole String description
// 3. "description" bierzemy z nowopowstałego serwisu korzystając z RestTemplate

// Budowanie obrazu Docker: mvn spring-boot:build-image -DskipTests
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
