package org.xtremebiker.jsfspring.view;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.xtremebiker.jsfspring.Service.StatusService;
import org.xtremebiker.jsfspring.model.Position;
import org.xtremebiker.jsfspring.model.Status;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Component(value = "liststatus")
@SessionScope
public class StatusView
{
    @Autowired
    private StatusService statusService;
    private Status newGame=new Status();
    private List<Status> statusList;
    public String delete(Status status)
    {
        statusService.delete(status);
        statusList.remove(status);
        return "listStatus?faces-redirect=true";
    }
    @PostConstruct
    public void init() {
        statusList = statusService.getAll();

    }
    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }
    public Status getNewGame() {
        return newGame;
    }

    public void setNewGame(Status newGame) {
        this.newGame = newGame;
    }

    public void onRowEdit(RowEditEvent event) {
        Status new_status=(Status)event.getObject();
        statusService.save(new_status);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "X/Y edit successful!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        int i=0;
        i++;

    }
    public String createNew()
    {
        statusService.save(newGame);
        statusList.add(newGame);
        newGame = new Status();
        return "listStatus?faces-redirect=true";
    }


}
