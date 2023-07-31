package com.stark.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieDto {
    private Long id;

    private String name;

    private String director;

    public MovieDto(String name, String director, String genre) {
        this.name = name;
        this.director = director;
        this.genre = genre;
    }

    private String genre;
}
