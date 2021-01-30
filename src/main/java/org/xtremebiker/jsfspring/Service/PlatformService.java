package org.xtremebiker.jsfspring.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xtremebiker.jsfspring.model.Game;
import org.xtremebiker.jsfspring.model.Platform;
import org.xtremebiker.jsfspring.repository.GamesRepository;
import org.xtremebiker.jsfspring.repository.PlatformRepository;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Service
@Transactional
public class PlatformService
{
    @Autowired
    private PlatformRepository addressRepository;
    public void save(Platform game) {
        Platform savedBank = addressRepository.save(game);
    }

    public void delete(Platform game) {
        addressRepository.delete(game);
    }

    public Platform getById(Long id) {
        return addressRepository.findById(id).get();
    }
    public Platform getByName(String name ) {
        return addressRepository.findByName(name);
    }

    public Platform editBank(Platform game) {
        return addressRepository.save(game);
    }

    public List<Platform> getAll()
    {

        return   addressRepository.findAllByOrderByIdDesc();

    }
}
