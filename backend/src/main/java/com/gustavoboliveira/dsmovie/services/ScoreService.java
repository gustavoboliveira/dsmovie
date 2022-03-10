package com.gustavoboliveira.dsmovie.services;

import com.gustavoboliveira.dsmovie.dto.MovieDTO;
import com.gustavoboliveira.dsmovie.dto.ScoreDTO;
import com.gustavoboliveira.dsmovie.entities.Movie;
import com.gustavoboliveira.dsmovie.entities.Score;
import com.gustavoboliveira.dsmovie.entities.User;
import com.gustavoboliveira.dsmovie.repositories.MovieRepository;
import com.gustavoboliveira.dsmovie.repositories.ScoreRepository;
import com.gustavoboliveira.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto){
        User user = userRepository.findByEmail(dto.getEmail());
        if(user == null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for(Score s : movie.getScores())
            sum += s.getValue();
        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}