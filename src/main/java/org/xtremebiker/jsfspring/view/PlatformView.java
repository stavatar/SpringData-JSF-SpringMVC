package org.xtremebiker.jsfspring.view;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.xtremebiker.jsfspring.Service.PlatformService;
import org.xtremebiker.jsfspring.model.InterviewStage;
import org.xtremebiker.jsfspring.model.Platform;
import org.xtremebiker.jsfspring.model.Position;
import org.xtremebiker.jsfspring.model.Status;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Component(value = "listplatform")
@SessionScope
public class PlatformView
{
    @Autowired
    private PlatformService platformService;
    private List<Platform> platformList;

    public Platform getNewplatform() {
        return newplatform;
    }

    public void setNewplatform(Platform newplatform) {
        this.newplatform = newplatform;
    }

    private Platform newplatform;
    public String delete(Platform platform)
    {
        platformService.delete(platform);
        platformList.remove(platform);
        return "listplatform?faces-redirect=true";

    }
    @PostConstruct
    public void init() {
        platformList = platformService.getAll();

    }
    public void onRowEdit(RowEditEvent event) {
        Platform new_platform=(Platform)event.getObject();
        platformService.save(new_platform);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "X/Y edit successful!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        int i=0;
        i++;

    }

    public List<Platform> getPlatformList() {
        return platformList;
    }

    public void setPlatformList(List<Platform> platformList) {
        this.platformList = platformList;
    }
    public String createNew()
    {
        platformService.save(newplatform);
        platformList.add(newplatform);
        newplatform = new Platform();
        return "listplatform?faces-redirect=true";
    }

}
