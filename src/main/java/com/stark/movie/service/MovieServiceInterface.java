package com.stark.movie.service;

import com.stark.movie.dto.MovieDto;
import com.stark.movie.entity.Movie;

import java.util.List;

public interface MovieServiceInterface {
    public MovieDto getMovie(Long id);
    public List<MovieDto> getMovies();
    public MovieDto addMovie(MovieDto movieDto);

    public MovieDto updateMovie(Long id, MovieDto movieDto);

    public void deleteMovie(Long id);

    public List<MovieDto> getMoviesByGenre(String genre);
}
