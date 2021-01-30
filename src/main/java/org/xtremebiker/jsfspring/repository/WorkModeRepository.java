package org.xtremebiker.jsfspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.xtremebiker.jsfspring.model.Genre;
import org.xtremebiker.jsfspring.model.Platform;
import org.xtremebiker.jsfspring.model.Status;
import org.xtremebiker.jsfspring.model.WorkMode;

import java.util.List;
import java.util.Optional;

public interface WorkModeRepository extends CrudRepository<WorkMode, Long>
{
    Optional<WorkMode> findById(Long id);
    WorkMode findByName(String nameGame);

    List<WorkMode> findAllByOrderByIdDesc();
}