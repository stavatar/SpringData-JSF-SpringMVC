package org.xtremebiker.jsfspring.Converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xtremebiker.jsfspring.Service.StatusService;
import org.xtremebiker.jsfspring.Service.WorkModeService;
import org.xtremebiker.jsfspring.model.Status;
import org.xtremebiker.jsfspring.model.WorkMode;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@Component("WorkModeConverter")
public class WorkModeConverter implements Converter {
    @Autowired
    private WorkModeService gamesService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s)
    {
        if (s == null || s.isEmpty()) {
            return null;
        }

        try {
            WorkMode workMode= gamesService.getById(Long.valueOf(s));
            return workMode;
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

        if (o instanceof WorkMode) {
            return String.valueOf(((WorkMode) o).getId());
        } else {
            throw new ConverterException(new FacesMessage(o + " is not a valid Warehouse"));
        }
    }
}