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
    public MovieDto getMovie(Long id) {
         Movie mo = movieRepo.findById(id).get();
         MovieDto movieDto = convertEntityToDto(mo);
         return movieDto;
    }

    @Override
    public List<MovieDto> getMovies() {
        List<Movie> movies = movieRepo.findAll();
        return movies.stream().map(movie -> convertEntityToDto(movie)).toList();
    }

    @Override
    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = convertDtoToEntity(movieDto);
        Movie savedMovie = movieRepo.save(movie);
        return convertEntityToDto(savedMovie);
    }

    @Override
    public MovieDto updateMovie(Long id, MovieDto movieDto) {
        Movie currentMovie = movieRepo.findById(id).get();
        if(movieDto.getName() != null){
            currentMovie.setName(movieDto.getName());
        }
        if (movieDto.getGenre() != null){
            currentMovie.setGenre(movieDto.getGenre());
        }
        if(movieDto.getDirector()!= null){
            currentMovie.setDirector(movieDto.getDirector());
        }
        MovieDto updatedMovie = convertEntityToDto(currentMovie);
        return updatedMovie;
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepo.deleteById(id);
    }

    @Override
    public List<MovieDto> getMoviesByGenre(String genre) {
        List<Movie> movies = movieRepo.findByGenre(genre);
        return movies.stream().map(movie -> convertEntityToDto(movie)).toList();
    }

    private Movie convertDtoToEntity(MovieDto movieDto){
        Movie movie = modelMapper.map(movieDto, Movie.class);
        return movie;
    }

    private MovieDto convertEntityToDto(Movie movie){
        MovieDto movieDto = modelMapper.map(movie, MovieDto.class);
        return movieDto;
    }
}
