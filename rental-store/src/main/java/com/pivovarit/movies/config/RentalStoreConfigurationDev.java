package com.pivovarit.movies.config;

import com.pivovarit.movies.MovieDescriptionsRepository;
import com.pivovarit.movies.repository.InMemoryMovieRepository;
import com.pivovarit.movies.repository.MovieRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RentalStoreConfigurationDev {

    @Bean
    @Profile("dev")
    public MovieRepository movieRepository() {
        return new InMemoryMovieRepository();
    }

    @Bean
    @Profile("dev")
    public MovieDescriptionsRepository movieDescriptionsRepository() {
        return id -> "lorem ipsum";
    }
}
