package com.gustavoboliveira.dsmovie.controllers;

import com.gustavoboliveira.dsmovie.dto.MovieDTO;
import com.gustavoboliveira.dsmovie.dto.ScoreDTO;
import com.gustavoboliveira.dsmovie.services.MovieService;
import com.gustavoboliveira.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto){
        return service.saveScore(dto);
    }
}
