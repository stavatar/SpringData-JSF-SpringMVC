package org.xtremebiker.jsfspring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.xtremebiker.jsfspring.Service.GamesService;
import org.xtremebiker.jsfspring.model.Employee;

import java.util.List;

@Component(value = "gameteam")
@RequestScope
public class TeamView
{
    @Autowired
    private GamesService gamesService;
    private Long id;
    private List<Employee> team;


   public List<Employee> getTeam() {
        return team;
    }

    public void setTeam(List<Employee> team) {
        this.team = team;
    }

    public String save()
    {
        gamesService.getById(Math.toIntExact(id)).setListEmployes(team);
        return "listTeam?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
        team=gamesService.getTeam(Math.toIntExact(id));
    }
}
