package org.xtremebiker.jsfspring.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xtremebiker.jsfspring.model.Candidate;
import org.xtremebiker.jsfspring.model.Employee;
import org.xtremebiker.jsfspring.repository.EmployeesRepository;


import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Service
@Transactional
public class EmployesService
{
    @Autowired
    private EmployeesRepository employeeRepository;

    public void save(Employee game) {
        Employee savedBank = employeeRepository.save(game);
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id).get();
    }
    public void delete(Employee game) {
        employeeRepository.delete(game);
    }

    public Employee getByName(String name) {
        return employeeRepository.findByName(name);
    }


    public Employee editBank(Employee game) {
        return employeeRepository.save(game);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAllByOrderByIdDesc();
    }
}
