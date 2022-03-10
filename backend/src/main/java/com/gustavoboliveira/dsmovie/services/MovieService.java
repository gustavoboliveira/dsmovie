package com.gustavoboliveira.dsmovie.services;

import com.gustavoboliveira.dsmovie.dto.MovieDTO;
import com.gustavoboliveira.dsmovie.entities.Movie;
import com.gustavoboliveira.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable){
        Page<Movie> result = repository.findAll(pageable);
        return result.map(MovieDTO::new);
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id){
        Movie movie = repository.findById(id).get();
        MovieDTO dto = new MovieDTO(movie);
        return dto;
    }


}
