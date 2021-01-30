package org.xtremebiker.jsfspring.model;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter

@AllArgsConstructor
@Entity
@Transactional
@Table(name = "game")
public class Game
{
    public Game()
    {
        Hibernate.initialize(listGenre);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "budget")
    private Integer budget;
    @Column(name = "profit")
    private  Integer profit;
    @Column(name = "number")
    private  Integer number;
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "platform")
    private  Platform platform;
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "status")
    private Status status;
    @Column(name = "start")
    @Temporal(TemporalType.DATE)
    private Date start;
    @Temporal(TemporalType.DATE)
    @Column(nullable = true,name = "endTime")
    private Date end;
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "games_genres",
               joinColumns = @JoinColumn(name= "game_id"),
               inverseJoinColumns =  @JoinColumn(name= "genre_id"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Genre> listGenre;
    @ManyToMany()
    @JoinTable(name = "employes_games",
            joinColumns = @JoinColumn(name= "game_id"),
            inverseJoinColumns =  @JoinColumn(name= "employee_id"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Employee> listEmployes;


    public List<Employee> getListEmployes() {
        return listEmployes;
    }

    public void setListEmployes(List<Employee> listEmployes) {
        this.listEmployes = listEmployes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return id == game.id &&
                Objects.equal(name, game.name) &&
                Objects.equal(budget, game.budget) &&
                Objects.equal(profit, game.profit) &&
                Objects.equal(number, game.number) &&
                Objects.equal(platform, game.platform) &&
                Objects.equal(status, game.status) &&
                Objects.equal(start, game.start) &&
                Objects.equal(end, game.end) &&
                Objects.equal(listGenre, game.listGenre) &&
                Objects.equal(listEmployes, game.listEmployes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, budget, profit, number, platform, status, start, end, listGenre, listEmployes);
    }




    public void update(Game new_game)
    {
        this.name = new_game.name;
        this.budget = new_game.budget;
        this.profit = new_game.profit;
        this.number = new_game.number;

        this.platform = new_game.platform;
        this.status = new_game.status;
        this.start = new_game.start;
        this.end = new_game.end;
    }
}
