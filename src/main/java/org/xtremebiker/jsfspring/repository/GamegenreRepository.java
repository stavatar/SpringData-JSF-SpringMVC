package org.xtremebiker.jsfspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.xtremebiker.jsfspring.model.Game;
import org.xtremebiker.jsfspring.model.Gamegenre;

import java.util.List;

public interface GamegenreRepository extends CrudRepository<Gamegenre, Long>
{
        List<Gamegenre> findAllByOrderByIdDesc();
}