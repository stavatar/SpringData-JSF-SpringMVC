package org.xtremebiker.jsfspring.view;

import org.hibernate.Hibernate;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.xtremebiker.jsfspring.Service.GenreService;
import org.xtremebiker.jsfspring.model.Genre;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Component(value = "listgenres")
@SessionScope
public class GenresView
{
    @Autowired
    private GenreService genreService;
    private Genre newGame=new Genre();
    private List<Genre> genreList;
    @PostConstruct
    public void init() {
        genreList = genreService.getAll();
        Hibernate.initialize(genreList);
    }
    public List<Genre> getGenreList() {
        return genreList;
    }
    public String delete(Genre genre)
    {
        genreService.delete(genre);
        genreList.remove(genre);
        return "listGenre?faces-redirect=true";

    }
    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public Genre getNewGame() {
        return newGame;
    }

    public void setNewGame(Genre newGame) {
        this.newGame = newGame;
    }

    public void onRowEdit(RowEditEvent event) {
        Genre new_genre=(Genre)event.getObject();
        genreService.save(new_genre);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "X/Y edit successful!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        int i=0;
        i++;

    }
    public String createNew()
    {
        genreService.save(newGame);
        genreList.add(newGame);
        newGame = new Genre();
        return "listGenre?faces-redirect=true";
    }

    public List<Genre> getAll_games() {
        return genreService.getAll();
    }

}
