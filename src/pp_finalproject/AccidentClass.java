/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.Accident;

import estgconstroi.ConstructionSite;
import estgconstroi.Employee;
import estgconstroi.Event;
import estgconstroi.enums.EventPriority;


public class AccidentClass extends Event implements Accident{

    private Employee employee;
    private String details;
    private String notification;
    
    public AccidentClass(Employee employee, String details, String notification,EventPriority priority, String title, Employee reporter,ConstructionSite constructionSite){
            super(priority, title, reporter, constructionSite);
        this.details = details;
        this.employee = employee;
        this.notification = notification;
    }
    
    
    @Override
    public Employee getEmployee() {
        return this.employee;
       
    }

    @Override
    public String getDetails() {
        return this.details;
        
    }

    @Override
    public String getNotificationMessage() {
       return this.notification;
    }
}
