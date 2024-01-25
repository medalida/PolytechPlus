package com.server.cinemaepul.movie_genre;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;
    public List<MovieGenre> findAll() {
        return categorieRepository.findAll();
    }
}
