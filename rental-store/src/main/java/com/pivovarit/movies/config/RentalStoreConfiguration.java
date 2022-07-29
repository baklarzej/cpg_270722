package com.pivovarit.movies.config;

import com.pivovarit.movies.HelloWorldService;
import com.pivovarit.movies.MovieDescriptionsRepository;
import com.pivovarit.movies.MoviePriceCalculator;
import com.pivovarit.movies.repository.MovieRepository;
import com.pivovarit.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class RentalStoreConfiguration {

    @Bean
    public RestTemplate restTemplate(List<HttpMessageConverter<?>> messageConverters) {
        return new RestTemplate(messageConverters);
    }

    @Bean
    public HelloWorldService helloWorldService(@Value("${hello.message}") String msg) {
        return new HelloWorldService(msg);
    }

    @Bean
    public MoviePriceCalculator moviePriceCalculator(
      @Value("${rental.price.new}") long priceNew,
      @Value("${rental.price.regular}") long priceRegular,
      @Value("${rental.price.old}") long priceOld) {
        return new MoviePriceCalculator(priceNew, priceRegular, priceOld);
    }

    @Bean
    public MovieService movieService(
      MovieRepository movieRepository,
      MoviePriceCalculator moviePriceCalculator,
      MovieDescriptionsRepository movieDescriptionsRepository) {
        return new MovieService(movieRepository, moviePriceCalculator, movieDescriptionsRepository);
    }

    @Bean
    public CommandLineRunner runner(HelloWorldService helloWorldService) {
        return __ -> helloWorldService.hello();
    }
}
