package org.xtremebiker.jsfspring.Converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xtremebiker.jsfspring.Service.InterviewStageService;
import org.xtremebiker.jsfspring.Service.WorkModeService;
import org.xtremebiker.jsfspring.model.Genre;
import org.xtremebiker.jsfspring.model.InterviewStage;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@Component("interviewConverter")
public class InterviewConverter implements Converter {
    @Autowired
    private InterviewStageService gamesService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s)
    {
        if (s == null || s.isEmpty()) {
            return null;
        }

        try {
            InterviewStage stage=gamesService.getById(Long.valueOf(s));
        return stage;
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(s + " is not a valid Warehouse ID"), e);
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o)
    {
        if (o == null) {
            return ""; // Never return null here!
        }

        if (o instanceof InterviewStage) {
            return String.valueOf(((InterviewStage) o).getId());
        } else {
            throw new ConverterException(new FacesMessage(o + " is not a valid Warehouse"));
        }
    }
}