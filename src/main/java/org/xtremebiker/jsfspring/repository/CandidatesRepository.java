package org.xtremebiker.jsfspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.xtremebiker.jsfspring.model.Candidate;
import org.xtremebiker.jsfspring.model.Employee;
import org.xtremebiker.jsfspring.model.Game;

import java.util.List;

public interface CandidatesRepository extends CrudRepository<Candidate, Long>
{
    Candidate findByName(String nameGame);
    List<Candidate> findAllByOrderByIdDesc();

}
