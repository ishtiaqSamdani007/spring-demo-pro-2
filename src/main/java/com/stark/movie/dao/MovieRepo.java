package com.stark.movie.dao;

import com.stark.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

   public List<Movie> findByGenre(String genre);
}
