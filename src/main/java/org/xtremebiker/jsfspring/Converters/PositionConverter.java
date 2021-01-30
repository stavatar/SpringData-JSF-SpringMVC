package org.xtremebiker.jsfspring.Converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xtremebiker.jsfspring.Service.GamesService;
import org.xtremebiker.jsfspring.Service.PlatformService;
import org.xtremebiker.jsfspring.Service.PositionService;
import org.xtremebiker.jsfspring.model.InterviewStage;
import org.xtremebiker.jsfspring.model.Position;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
@Component("positionConverter")
public class PositionConverter implements Converter {
    @Autowired
    private PositionService gamesService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s)
    {
        if (s == null || s.isEmpty()) {
            return null;
        }

        try {
            Position position= gamesService.getById(Long.valueOf(s));
            return position;
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

        if (o instanceof Position) {
            return String.valueOf(((Position) o).getId());
        } else {
            throw new ConverterException(new FacesMessage(o + " is not a valid Warehouse"));
        }    }
}