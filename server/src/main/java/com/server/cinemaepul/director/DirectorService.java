package com.server.cinemaepul.director;

import com.server.cinemaepul.movie.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    public Director getByIdOrThrow(Integer realisateurId) {
        return directorRepository.findById(realisateurId)
                .orElseThrow(() -> {
                    log.error("Realisateur {} non trouvé en base", realisateurId);
                    return new RuntimeException("Le realisateur n'a pas été trouvé");
                });
    }

    public List<Director> findAll() {
        return directorRepository.findAll();
    }

//    public Director findByNom(String nom) {
//        return realisateurRepository.findByNomRea(nom);
//    }

    public Director create(Director director) {
        return directorRepository.save(director);
    }

    public Director update(Integer director_id, Director director) {
        Director old_director = getByIdOrThrow(director_id);
        director.setId(old_director.getId());
        return directorRepository.save(director);
    }

    public Integer delete(Integer director_id) {
        directorRepository.deleteById(director_id);
        return director_id;
    }
}
