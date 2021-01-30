package org.xtremebiker.jsfspring.view;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.xtremebiker.jsfspring.Service.CandidatesService;
import org.xtremebiker.jsfspring.model.Candidate;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Component(value = "listcandidates")
@SessionScope
public class CandidatesView
{
    private Candidate newGame=new Candidate();
    @Autowired
    private CandidatesService gamesService;
    private List<Candidate>  allcandidates;

    public String delete(Candidate candidate)

    {
        gamesService.delete(candidate);
        allcandidates.remove(candidate);
        return "listCandidates?faces-redirect=true";

    }
    public List<Candidate> getAllcandidates() {
        return allcandidates;
    }

    public void setAllcandidates(List<Candidate> allcandidates) {
        this.allcandidates = allcandidates;
    }

    @PostConstruct
    public void init() {
        allcandidates = gamesService.getAll();

        newGame = new Candidate();
    }
    public Candidate getNewGame() {
        return newGame;
    }

    public void setNewGame(Candidate newGame) {
        this.newGame = newGame;
    }

    public void onRowEdit(RowEditEvent event) {
        Candidate new_candidate=(Candidate)event.getObject();
        gamesService.save(new_candidate);
        allcandidates = gamesService.getAll();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "X/Y edit successful!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        int i=0;
        i++;

    }
    public String createNew()
    {

        gamesService.save(newGame);
        if (newGame.getInterview_stage().getId()!=6)allcandidates.add(newGame);
        newGame = new Candidate();
        return "listCandidates?faces-redirect=true";
    }
}

