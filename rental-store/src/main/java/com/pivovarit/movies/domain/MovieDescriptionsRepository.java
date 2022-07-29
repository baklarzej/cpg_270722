package com.pivovarit.movies.domain;

interface MovieDescriptionsRepository {
    String getDescriptionFor(long movieId);
}
