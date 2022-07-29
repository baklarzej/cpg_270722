package com.pivovarit.movies.domain;

import com.pivovarit.movies.MoviePriceCalculator;
import com.pivovarit.movies.api.MovieAddRequest;
import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.repository.InMemoryMovieRepository;
import com.pivovarit.movies.service.MovieService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovieServiceTest {

    @Test
    void should_add_movie() {
        MovieService service = inMemoryInstance();
        MovieAddRequest newMovie = new MovieAddRequest(1, "Spiderman", "REGULAR");
        service.addMovie(newMovie);

        MovieDto movie = service.findById(1).get();

        TestUtils.equals(newMovie, movie);
        assertThat(movie.getDescription()).isEqualTo("foo");
    }

    private static MovieService inMemoryInstance() {
        return new MovieService(new InMemoryMovieRepository(), new MoviePriceCalculator(10, 8, 5), id -> "foo");
    }
}
