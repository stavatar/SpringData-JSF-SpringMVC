package org.xtremebiker.jsfspring.view;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.xtremebiker.jsfspring.Service.PositionService;
import org.xtremebiker.jsfspring.model.InterviewStage;
import org.xtremebiker.jsfspring.model.Platform;
import org.xtremebiker.jsfspring.model.Position;
import org.xtremebiker.jsfspring.model.Status;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;
@Component(value = "listPosition")
@SessionScope
public class PositionView
{
    @Autowired
    private PositionService positionService;
    private Position newGame=new Position();
    private List<Position> positionList;
    public String delete(Position position)
    {
        positionService.delete(position);
        positionList.remove(position);
        return "listPosition?faces-redirect=true";

    }
    @PostConstruct
    public void init() {
        positionList = positionService.getAll();

    }
    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }
    public Position getNewGame() {
        return newGame;
    }
    public void setNewGame(Position newGame) {
        this.newGame = newGame;
    }
    public void onRowEdit(RowEditEvent event) {
        Position new_position=(Position)event.getObject();
        positionService.save(new_position);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "X/Y edit successful!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        int i=0;
        i++;
    }

    public String createNew()
    {
        positionService.save(newGame);
        positionList.add(newGame);
        newGame = new Position();
        return "listPosition?faces-redirect=true";
    }

}
