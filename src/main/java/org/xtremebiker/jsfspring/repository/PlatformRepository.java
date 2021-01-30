package org.xtremebiker.jsfspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.xtremebiker.jsfspring.model.InterviewStage;
import org.xtremebiker.jsfspring.model.Platform;

import java.util.List;
import java.util.Optional;

public interface PlatformRepository extends CrudRepository<Platform, Long> {
    Optional<Platform> findById(Long id);
    Platform findByName(String nameGame);
    List<Platform> findAllByOrderByIdDesc();
}