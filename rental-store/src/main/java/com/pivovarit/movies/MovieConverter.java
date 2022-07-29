package com.pivovarit.movies;

import com.pivovarit.movies.api.MovieAddRequest;
import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.domain.Movie;
import com.pivovarit.movies.domain.MovieId;
import com.pivovarit.movies.domain.MovieType;

public final class MovieConverter {

    public static Movie from(MovieAddRequest request) {
        return new Movie(new MovieId(request.getId()), request.getTitle(), MovieType.valueOf(request.getType()));
    }

    public static MovieDto from(Movie movie, String description) {
        return new MovieDto(movie.getId().getId(), movie.getTitle(), movie.getType().toString(), description);
    }
}
