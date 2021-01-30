package org.xtremebiker.jsfspring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.xtremebiker.jsfspring.model.Game;
import org.xtremebiker.jsfspring.model.Genre;
import org.xtremebiker.jsfspring.model.Platform;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long>, JpaSpecificationExecutor<Genre> {
    Genre findByName(String nameGame);
    Optional<Genre> findById(Long id);
    List<Genre> findAllByOrderByIdDesc();
}