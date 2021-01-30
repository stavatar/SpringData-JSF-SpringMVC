package org.xtremebiker.jsfspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.xtremebiker.jsfspring.model.InterviewStage;
import org.xtremebiker.jsfspring.model.Platform;
import org.xtremebiker.jsfspring.model.WorkMode;

import java.util.List;
import java.util.Optional;

public interface InterviewStageRepository extends CrudRepository<InterviewStage, Long>
{
    InterviewStage findByName(String nameGame);
    Optional<InterviewStage> findById(Long id);
    List<InterviewStage> findAllByOrderByIdDesc();
}