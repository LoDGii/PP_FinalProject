/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.ConstructionSite;
import estgconstroi.Employee;
import estgconstroi.Equipment;
import estgconstroi.Event;
import estgconstroi.Failure;
import estgconstroi.enums.EventPriority;

/**
 *
 * @author Utilizador
 */
public class FailureClass extends Event implements Failure {

    private Equipment equipment;
    private String details;
    private String notification;

    public FailureClass(Equipment equipment, String details, String notification, EventPriority priority, String title, Employee reporter, ConstructionSite TempConstructionSite) {
        super(priority, title, reporter, TempConstructionSite);
        this.equipment = equipment;
        this.details = details;
        this.notification = notification;
    }

    @Override
    public Equipment getEquipment() {
        return this.equipment;
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
