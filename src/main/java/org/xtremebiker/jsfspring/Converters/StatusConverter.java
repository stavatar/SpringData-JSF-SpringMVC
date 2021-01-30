package org.xtremebiker.jsfspring.Converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xtremebiker.jsfspring.Service.PositionService;
import org.xtremebiker.jsfspring.Service.StatusService;
import org.xtremebiker.jsfspring.model.Position;
import org.xtremebiker.jsfspring.model.Status;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@Component("statusConverter")
public class StatusConverter implements Converter {
    @Autowired
    private StatusService gamesService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s)
    {

        if (s == null || s.isEmpty()) {
            return null;
        }

        try {
            Status status= gamesService.getById(Long.valueOf(s));
            return  status;
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

        if (o instanceof Status) {
            return String.valueOf(((Status) o).getId());
        } else {
            throw new ConverterException(new FacesMessage(o + " is not a valid Warehouse"));
        }
    }

}