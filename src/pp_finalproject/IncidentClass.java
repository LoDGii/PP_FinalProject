/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.ConstructionSite;
import estgconstroi.Incident;

/**
 *
 * @author Utilizador
 */
public class IncidentClass implements Incident{
    private ConstructionSite ConstructionSite;
    private String details;
    private String notificationMessage;

        
    @Override
    public String getDetails() {
        return this.details;
    }
    @Override
    public String getNotificationMessage() {
        return this.notificationMessage;
    }
    
}
