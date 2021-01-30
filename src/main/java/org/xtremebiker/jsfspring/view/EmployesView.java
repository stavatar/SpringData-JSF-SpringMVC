package org.xtremebiker.jsfspring.view;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.xtremebiker.jsfspring.Service.EmployesService;
import org.xtremebiker.jsfspring.model.Employee;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Component(value = "listemployees")
@SessionScope
public class EmployesView
{
    @Autowired
    private EmployesService employesService;
    private Employee newEmpl= new Employee();
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    public String delete(Employee employee)
    {
        employesService.delete(employee);
        employeeList.remove(employee);
        return "listEmployes?faces-redirect=true";


    }
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    @PostConstruct
    public void init()
    {
        employeeList = employesService.getAll();
    }
    public Employee getNewEmpl() {
        return newEmpl;
    }

    public void setNewEmpl(Employee newEmpl) {
        this.newEmpl = newEmpl;
    }



    public void onRowEdit(RowEditEvent event) {
        Employee new_empl=(Employee)event.getObject();
        employesService.save(new_empl);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "X/Y edit successful!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        int i=0;
        i++;
    }

    public String createNew()
    {
        employesService.save(newEmpl);
        employeeList.add(newEmpl);

        newEmpl = new Employee();
        return "listEmployes?faces-redirect=true";
    }

}
