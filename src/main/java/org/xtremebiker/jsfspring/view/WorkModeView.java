package org.xtremebiker.jsfspring.view;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.xtremebiker.jsfspring.Service.WorkModeService;
import org.xtremebiker.jsfspring.model.WorkMode;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Component(value = "listworkmodes")
@SessionScope
public class WorkModeView
{
    @Autowired @Qualifier("workmodeservice")
    private WorkModeService workModeService;

    private WorkMode workMode  =new WorkMode();

    private List<WorkMode> workModes;

    public String delete(WorkMode workmode)
    {
        workModeService.delete(workmode);
        workModes.remove(workmode);
        return "listWorkMode?faces-redirect=true";

    }
    @PostConstruct
    public void init() {
        workModes = workModeService.getAll();

    }
    public List<WorkMode> getWorkModes() {
        return workModes;
    }

    public void setWorkModes(List<WorkMode> workModes) {
        this.workModes = workModes;
    }
    public WorkMode getWorkMode() {
        return workMode;
    }

    public void setWorkMode(WorkMode workMode) {
        this.workMode = workMode;
    }

    public void onRowEdit(RowEditEvent event)
    {
        WorkMode new_workmode=(WorkMode)event.getObject();
        workModeService.save(new_workmode);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "X/Y edit successful!");
        FacesContext.getCurrentInstance().addMessage(null, msg);


    }
    public String createNew()
    {
        workModeService.save(workMode);
        workModes.add(workMode);
        workMode = new WorkMode();
        return "listWorkMode?faces-redirect=true";
    }


}
