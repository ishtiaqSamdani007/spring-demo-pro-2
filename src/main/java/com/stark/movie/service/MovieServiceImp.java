package com.stark.movie.service;

import com.stark.movie.dao.MovieRepo;
import com.stark.movie.dto.MovieDto;
import com.stark.movie.entity.Movie;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieServiceImp implements MovieServiceInterface {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Movie getMovie(Long id) {
         Optional<Movie> mo = movieRepo.findById(id);
         return mo.orElseGet(Movie::new);
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepo.findAll();
    }

    @Override
    public Movie addMovie(MovieDto movieDto) {
        Movie movie = modelMapper.map(movieDto, Movie.class);

        return movieRepo.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, Movie movie) {
        Movie existingMovie = movieRepo.findById(id).get();
        if(movie.getName()!=null)
            existingMovie.setName(movie.getName());
        if(movie.getGenre()!=null)
            existingMovie.setGenre(movie.getGenre());
        if(movie.getDirector()!=null)
            existingMovie.setDirector(movie.getDirector());
        return existingMovie;

    }

    @Override
    public void deleteMovie(Long id) {
        movieRepo.deleteById(id);
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepo.findByGenre(genre);
    }
}
