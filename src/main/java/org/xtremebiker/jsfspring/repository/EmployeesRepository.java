package org.xtremebiker.jsfspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.xtremebiker.jsfspring.model.Employee;
import org.xtremebiker.jsfspring.model.Genre;
import org.xtremebiker.jsfspring.model.Platform;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeesRepository extends CrudRepository<Employee, Long>
{
    Employee findByName(String nameGame);
    Optional<Employee> findById(int id);
    List<Employee> findAllByOrderByIdDesc();
}
