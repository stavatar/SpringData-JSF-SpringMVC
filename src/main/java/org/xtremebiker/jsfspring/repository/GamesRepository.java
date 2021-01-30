package org.xtremebiker.jsfspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.xtremebiker.jsfspring.model.Game;
import org.xtremebiker.jsfspring.model.Genre;

import java.util.List;
import java.util.Optional;

@Repository
public interface GamesRepository extends CrudRepository<Game, Long>
{
    Game findByName(String nameGame);
    Optional<Game> findById(int id);

    List<Game> findAllByOrderByIdDesc();
}
