package com.server.cinemaepul.director;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RealisateurRepository extends JpaRepository<Director, Integer> {
    //Director findByNomRea(String nomRea);
}
