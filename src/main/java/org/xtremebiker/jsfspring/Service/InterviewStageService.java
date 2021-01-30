package org.xtremebiker.jsfspring.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xtremebiker.jsfspring.model.Genre;
import org.xtremebiker.jsfspring.model.InterviewStage;
import org.xtremebiker.jsfspring.repository.InterviewStageRepository;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Service
@Transactional
public class InterviewStageService
{
    @Autowired
    private InterviewStageRepository interviewStageRepository;

    public void save(InterviewStage game) {
        InterviewStage savedBank = interviewStageRepository.save(game);


    }
    public InterviewStage getById(Long id) {
        return interviewStageRepository.findById(id).get();
    }
    public void delete(InterviewStage game) {
        interviewStageRepository.delete(game);
    }

    public InterviewStage getByName(String name) {
        return interviewStageRepository.findByName(name);
    }


    public InterviewStage editBank(InterviewStage game) {
        return interviewStageRepository.save(game);
    }

    public List<InterviewStage> getAll()
    {
        return   interviewStageRepository.findAllByOrderByIdDesc();
    }
}
