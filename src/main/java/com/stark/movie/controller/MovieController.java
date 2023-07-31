package com.stark.movie.controller;

import com.stark.movie.dto.MovieDto;
import com.stark.movie.entity.Movie;
import com.stark.movie.service.MovieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieServiceImp movieService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id){
        return movieService.getMovie(id);
    }

    @GetMapping
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }

    @PostMapping
    public Movie addMovie(@RequestBody MovieDto movieDto){
        return movieService.addMovie(movieDto);
    }

    @PatchMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre){
        return movieService.getMoviesByGenre(genre);
    }
}
