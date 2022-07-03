/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.ConstructionSite;
import estgconstroi.Employee;
import estgconstroi.Event;
import estgconstroi.Incident;
import estgconstroi.enums.EventPriority;

/**
 *
 * @author Utilizador
 */
public class IncidentClass extends Event implements Incident{
    private String details;
    private String notificationMessage;

        public IncidentClass(ConstructionSite TempConstructionSite, String TempDetails, String TempNotificationMessage, EventPriority TempPriority, String TempTitle, Employee TempReporter){
            super(TempPriority, TempTitle, TempReporter, TempConstructionSite);
            this.details = TempDetails;
            this.notificationMessage = TempNotificationMessage;
            
        }
        
    @Override
    public String getDetails() {
        return this.details;
    }
    @Override
    public String getNotificationMessage() {
        return this.notificationMessage;
    }
    
}
