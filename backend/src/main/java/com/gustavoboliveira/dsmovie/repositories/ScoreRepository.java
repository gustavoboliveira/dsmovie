package com.gustavoboliveira.dsmovie.repositories;

import com.gustavoboliveira.dsmovie.entities.Score;
import com.gustavoboliveira.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
