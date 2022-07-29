package com.pivovarit.movies.config;

import com.pivovarit.movies.MovieDescriptionsRepository;
import com.pivovarit.movies.RestTemplateDescriptionsClient;
import com.pivovarit.movies.repository.InMemoryMovieRepository;
import com.pivovarit.movies.repository.JdbcTemplateMovieRepository;
import com.pivovarit.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
public class RentalStoreConfigurationProd {

    @Bean
    @Profile("prod")
    public MovieDescriptionsRepository movieDescriptionsRepository(
      @Value("${service.descriptions.url}") String url,
      RestTemplate restTemplate) {
        return new RestTemplateDescriptionsClient(url, restTemplate);

    }

    @Bean
    @Profile("prod")
    public MovieRepository jdbcTemplateMovieRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcTemplateMovieRepository(jdbcTemplate);
    }
}
