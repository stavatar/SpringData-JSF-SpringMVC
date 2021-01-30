package org.xtremebiker.jsfspring.view;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.xtremebiker.jsfspring.Service.InterviewStageService;
import org.xtremebiker.jsfspring.model.InterviewStage;
import org.xtremebiker.jsfspring.model.Status;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Component(value = "listinterview")
@SessionScope
public class InterviewStageView
{
    @Autowired
    private InterviewStageService interviewStageService;
    private InterviewStage newGame=new InterviewStage();

    private List<InterviewStage> interviewStageList;
    public String delete(InterviewStage interviewStage)
    {
        interviewStageService.delete(interviewStage);
        interviewStageList.remove(interviewStage);
        return "listInterviewStage?faces-redirect=true";
    }
    @PostConstruct
    public void init() {
        interviewStageList = interviewStageService.getAll();

    }
    public List<InterviewStage> getInterviewStageList() {
        return interviewStageList;
    }

    public void setInterviewStageList(List<InterviewStage> interviewStageList) {
        this.interviewStageList = interviewStageList;
    }
    public void onRowEdit(RowEditEvent event) {
        InterviewStage new_interview=(InterviewStage)event.getObject();
         interviewStageService.save(new_interview);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "X/Y edit successful!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        int i=0;
        i++;

    }
    public String createNew()
    {
        interviewStageService.save(newGame);
        interviewStageList.add(newGame);
        newGame = new InterviewStage();
        return "listInterviewStage?faces-redirect=true";
    }

    public InterviewStage getNewGame() {
        return newGame;
    }

    public void setNewGame(InterviewStage newGame) {
        this.newGame = newGame;
    }


}
