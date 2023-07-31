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
    public MovieDto getMovie(@PathVariable Long id){
        return movieService.getMovie(id);
    }

    @GetMapping
    public List<MovieDto> getMovies(){
        return movieService.getMovies();
    }

    @PostMapping
    public MovieDto addMovie(@RequestBody MovieDto movieDto){
        return movieService.addMovie(movieDto);
    }

    @PatchMapping("/{id}")
    public MovieDto updateMovie(@PathVariable Long id, @RequestBody MovieDto movieDto){
        return movieService.updateMovie(id, movieDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
    }

    @GetMapping("/genre/{genre}")
    public List<MovieDto> getMoviesByGenre(@PathVariable String genre){
        return movieService.getMoviesByGenre(genre);
    }
}
