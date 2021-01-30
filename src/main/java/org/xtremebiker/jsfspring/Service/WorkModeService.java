package org.xtremebiker.jsfspring.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xtremebiker.jsfspring.model.Status;
import org.xtremebiker.jsfspring.model.WorkMode;
import org.xtremebiker.jsfspring.repository.WorkModeRepository;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Service("workmodeservice")
@Transactional
public class WorkModeService
{
    @Autowired
    private WorkModeRepository workModeRepository;

    public void save(WorkMode game) {
        WorkMode savedBank = workModeRepository.save(game);


    }
    public WorkMode getById(Long id) {
        return workModeRepository.findById(id).get();
    }
    public void delete(WorkMode game) {
        workModeRepository.delete(game);
    }
    public WorkMode getByName(String name ) {
        return workModeRepository.findByName(name);
    }



    public WorkMode editBank(WorkMode game) {
        return workModeRepository.save(game);
    }

    public List<WorkMode> getAll()
    {
        return   workModeRepository.findAllByOrderByIdDesc();
    }
}
