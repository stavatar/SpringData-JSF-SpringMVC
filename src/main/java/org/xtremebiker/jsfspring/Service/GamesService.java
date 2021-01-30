package org.xtremebiker.jsfspring.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xtremebiker.jsfspring.model.*;
import org.xtremebiker.jsfspring.repository.GamesRepository;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Service
@Transactional
public class GamesService
{
    @Autowired
    private  GamesRepository gamesRepository;
    @Autowired
    private EmployesService  employesService;
    @Autowired
    private  GenreService  genreService;
    @Autowired
    private  StatusService statusService;
    @Autowired
    private  PlatformService platformService;
    @Autowired
    private  EmployesGamesService employesGamesService;


    public List<Employee> getTeam(int id)
    {
       return employesGamesService.getEmployesforGame(id);
    }
    public void save(Game game) {
        Game savedBank = gamesRepository.save(game);
    }
    public Game getById(int id)
    {
        return gamesRepository.findById(id).get();
    }
    public Employee getEmloyes(Integer id)
    {
        return employesService.getById(Long.valueOf(id));
    }
    public Genre getGenre(Integer id)
    {
        return genreService.getById(Long.valueOf(id));
    }
    public Status getStatus(Integer id)
    {
        return statusService.getById(Long.valueOf(id));
    }
    public Platform getPlatform(Integer id)
    {
        return  platformService.getById(Long.valueOf(id));
    }

    public void delete(Game game) {
        gamesRepository.delete(game);
    }

    public Game getByName(String name) {
        return gamesRepository.findByName(name);
    }


    public Game editBank(Game game) {
        return gamesRepository.save(game);
    }



    public List<Game> getAll()
    {

        return   gamesRepository.findAllByOrderByIdDesc();

    }

}
