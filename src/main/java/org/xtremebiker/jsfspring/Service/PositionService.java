package org.xtremebiker.jsfspring.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xtremebiker.jsfspring.model.Platform;
import org.xtremebiker.jsfspring.model.Position;
import org.xtremebiker.jsfspring.repository.PositionRepository;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Service
@Transactional
public class PositionService
{
    @Autowired
    private PositionRepository positionRepository;

    public void save(Position game) {
        Position savedBank = positionRepository.save(game);


    }

    public Position getByName(String name ) {
        return positionRepository.findByName(name);
    }

    public Position getById(Long id) {
        return positionRepository.findById(id).get();
    }
    public void delete(Position game) {
        positionRepository.delete(game);
    }



    public Position editBank(Position game) {
        return positionRepository.save(game);
    }

    public List<Position> getAll()
    {
        return   positionRepository.findAllByOrderByIdDesc();
    }
}
