package com.stark.movie.service;

import com.stark.movie.dto.MovieDto;
import com.stark.movie.entity.Movie;

import java.util.List;

public interface MovieServiceInterface {
    public Movie getMovie(Long id);
    public List<Movie> getMovies();
    public Movie addMovie(MovieDto movieDto);

    public Movie updateMovie(Long id, Movie movie);

    public void deleteMovie(Long id);

    public List<Movie> getMoviesByGenre(String genre);
}
