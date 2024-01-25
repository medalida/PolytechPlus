package com.server.cinemaepul.director;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RealisateurService {
    @Autowired
    private RealisateurRepository realisateurRepository;

    public Director getByIdOrThrow(Integer realisateurId) {
        return realisateurRepository.findById(realisateurId)
                .orElseThrow(() -> {
                    log.error("Realisateur {} non trouvé en base", realisateurId);
                    return new RuntimeException("Le realisateur n'a pas été trouvé");
                });
    }

    public List<Director> findAll() {
        return realisateurRepository.findAll();
    }

//    public Director findByNom(String nom) {
//        return realisateurRepository.findByNomRea(nom);
//    }

    public Director create(Director director) {
        return realisateurRepository.save(director);
    }

    public Director update(Integer director_id, Director director) {
        Director old_director = getByIdOrThrow(director_id);
        director.setId(old_director.getId());
        return realisateurRepository.save(director);
    }

    public Integer delete(Integer director_id) {
        realisateurRepository.deleteById(director_id);
        return director_id;
    }
}
