package org.xtremebiker.jsfspring.view;

import java.util.*;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.xtremebiker.jsfspring.Service.GamesService;
import org.xtremebiker.jsfspring.model.Employee;
import org.xtremebiker.jsfspring.model.Game;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;

@Component(value = "listgames")
@SessionScope
public class GamesView {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private GamesService gamesService;
    private Game newGame=new Game();
    private List<Game> listGames;


    public String delete(Game game)
	{
		gamesService.delete(game);
		listGames.remove(game);
		return "listGames?faces-redirect=true";

	}
	public List<Game> getListGames() {
		return listGames;
	}

	public void setListGames(List<Game> listGames) {
		this.listGames = listGames;
	}
	@PostConstruct
	public void init() {
		listGames = gamesService.getAll();
	}
	public Game getNewGame() {
		return newGame;
	}

	public GamesService getGamesService() {
		return gamesService;
	}

	public void setGamesService(GamesService gamesService) {
		this.gamesService = gamesService;
	}

	public void setNewGame(Game newGame) {
		this.newGame = newGame;
	}

	public void onRowEdit(RowEditEvent event) {
		Game new_game=(Game)event.getObject();

		gamesService.save(new_game);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "X/Y edit successful!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
			int i=0;
			i++;

	}
	public List<Employee> getTeam(Long id)
	{
		return gamesService.getTeam(Math.toIntExact(id));

	}
    public  void showTeam(Long id)
	{

		Map<String,Object> options = new HashMap<>();
		options.put("modal", true);
		options.put("width", 1000);

		options.put("contentWidth", "100%");
		options.put("headerElement", "customheader");

		Map<String, List<String>> params = new HashMap<>();
		params.put("id", Collections.singletonList(String.valueOf(id)));
		PrimeFaces.current().dialog().openDynamic("listTeam", options, params);
	}
	public String createNew()
	{
		    newGame.setStatus(gamesService.getStatus( 1));
			gamesService.save(newGame);
		    listGames.add(newGame);
			newGame = new Game();
			return "listGames?faces-redirect=true";
	}





}
