package org.xtremebiker.jsfspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.xtremebiker.jsfspring.model.Employee;
import org.xtremebiker.jsfspring.model.EmployesGames;
import org.xtremebiker.jsfspring.model.Game;

import java.util.List;

public interface EmployesGamesRepository  extends CrudRepository<EmployesGames, Long>
{
    List<EmployesGames> findAllByGameId(Game game);

    List<EmployesGames> findAllByOrderByIdDesc();
}