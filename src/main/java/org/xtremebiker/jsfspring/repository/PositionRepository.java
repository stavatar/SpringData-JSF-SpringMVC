package org.xtremebiker.jsfspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.xtremebiker.jsfspring.model.Platform;
import org.xtremebiker.jsfspring.model.Position;

import java.util.List;
import java.util.Optional;

public interface PositionRepository extends CrudRepository<Position, Long> {
    Optional<Position> findById(Long id);
    Position findByName(String nameGame);
    List<Position> findAllByOrderByIdDesc();
}