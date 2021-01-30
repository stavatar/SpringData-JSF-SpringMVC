package org.xtremebiker.jsfspring.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xtremebiker.jsfspring.model.Employee;
import org.xtremebiker.jsfspring.model.Genre;
import org.xtremebiker.jsfspring.repository.GenreRepository;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Service
@Transactional

public class GenreService
{
    @Autowired
    private GenreRepository genresRepository;
    public void save(Genre game) {
        Genre savedBank = genresRepository.save(game);
    }
    public Genre getById(Long id) {
        return genresRepository.findById(id).get();
    }
    public void delete(Genre game) {
        genresRepository.delete(game);
    }
    public Genre getByName(String name) {
        return genresRepository.findByName(name);
    }


    public List<Genre> getAll()
    {

        return   genresRepository.findAllByOrderByIdDesc();




    }
}
