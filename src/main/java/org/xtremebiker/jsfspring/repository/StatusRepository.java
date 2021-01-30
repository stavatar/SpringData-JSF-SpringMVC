package org.xtremebiker.jsfspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.xtremebiker.jsfspring.model.Platform;
import org.xtremebiker.jsfspring.model.Position;
import org.xtremebiker.jsfspring.model.Status;
import org.xtremebiker.jsfspring.model.WorkMode;

import java.util.List;
import java.util.Optional;

public interface StatusRepository extends CrudRepository<Status, Long>
{
    Optional<Status> findById(Long id);

    Status findByName(String name);

    List<Status> findAllByOrderByIdDesc();
}