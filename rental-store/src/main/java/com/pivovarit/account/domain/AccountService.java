package com.pivovarit.account.domain;

import com.pivovarit.movies.domain.MovieService;

public class AccountService {

    private final MovieService movieService;

    public AccountService(MovieService movieService) {
        this.movieService = movieService;
    }

}
