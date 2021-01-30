package org.xtremebiker.jsfspring.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xtremebiker.jsfspring.model.Candidate;
import org.xtremebiker.jsfspring.repository.CandidatesRepository;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Service
@Transactional
public class CandidatesService
{
    @Autowired
    private CandidatesRepository CandidatesRepository;

    public void save(Candidate game) {
        Candidate savedBank = CandidatesRepository.save(game);


    }
    public void delete(Candidate game) {
        CandidatesRepository.delete(game);
    }

    public Candidate getByName(String name) {
        return CandidatesRepository.findByName(name);
    }


    public Candidate editBank(Candidate game) {
        return CandidatesRepository.save(game);
    }

    public List<Candidate> getAll() {
        return CandidatesRepository.findAllByOrderByIdDesc();
    }
}
