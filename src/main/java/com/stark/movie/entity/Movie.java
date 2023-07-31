package com.stark.movie.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="movie")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Movie {
    @Id
    @SequenceGenerator(
            name = "Pupil_sequence",
            sequenceName = "Pupil_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Pupil_sequence"
    )
    private Long id;

    private String name;

    private String director;

    private String genre;

    public Movie(String name, String director, String genre) {
        this.name = name;
        this.director = director;
        this.genre = genre;
    }
}
