package org.xtremebiker.jsfspring.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xtremebiker.jsfspring.model.Employee;
import org.xtremebiker.jsfspring.model.EmployesGames;
import org.xtremebiker.jsfspring.model.Game;
import org.xtremebiker.jsfspring.repository.EmployeesRepository;
import org.xtremebiker.jsfspring.repository.EmployesGamesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class EmployesGamesService
{
    @Autowired
    private EmployesGamesRepository employesGamesRepository;

    @Autowired
    private GamesService gamesService;





    public void saveAll(List<EmployesGames> employesGames)
    {
        employesGamesRepository.saveAll(employesGames);
    }

    public List<Employee> getEmployesforGame(int id)
    {
        Game game=gamesService.getById( id);
        List<EmployesGames> employesGamesList=employesGamesRepository.findAllByGameId(game);
        List<Employee> employeeList=new ArrayList<>();
        employesGamesList.forEach(employesGames -> employeeList.add(employesGames.getEmployeeId()));
        return  employeeList;


    }

}
