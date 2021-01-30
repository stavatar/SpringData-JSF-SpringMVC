package org.xtremebiker.jsfspring.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xtremebiker.jsfspring.model.Status;
import org.xtremebiker.jsfspring.repository.StatusRepository;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Service
@Transactional
public class StatusService
{
    @Autowired
    private StatusRepository statusRepository;

    public void save(Status game) {
        Status savedBank = statusRepository.save(game);


    }
    public Status getById(Long id) {
        return statusRepository.findById(id).get();
    }
    public void delete(Status game) {
        statusRepository.delete(game);
    }

    public Status getByName(String name ) {
        return statusRepository.findByName(name);
    }


    public Status editBank(Status game) {
        return statusRepository.save(game);
    }

    public List<Status> getAll()
    {
        return   statusRepository.findAllByOrderByIdDesc();
    }
}
