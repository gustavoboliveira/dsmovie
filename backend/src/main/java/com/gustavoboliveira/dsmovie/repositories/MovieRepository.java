package com.gustavoboliveira.dsmovie.repositories;

import com.gustavoboliveira.dsmovie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
