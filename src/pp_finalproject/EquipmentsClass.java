/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.Equipment;
import estgconstroi.Equipments;
import estgconstroi.enums.EquipmentStatus;
import estgconstroi.enums.EquipmentType;
import estgconstroi.exceptions.ConstructionSiteException;

/**
 *
 * @author Utilizador
 */
public class EquipmentsClass implements Equipments{

    private EquipmentClass[] equipments;
    private int numberEquipments;
    
    public EquipmentsClass(){
        this.numberEquipments = 0;
        this.equipments = new EquipmentClass[10];
    }
    
    private void verifySize() {
        if (this.equipments.length == this.numberEquipments) {
            EquipmentClass[] newArray = new EquipmentClass[this.numberEquipments];
            for (int i = 0; i < this.numberEquipments; i++) {
                newArray[i] = this.equipments[i];
            }
            this.equipments = new EquipmentClass[this.numberEquipments + 10];
            for (int i = 0; i < this.numberEquipments; i++) {
                this.equipments[i] = newArray[i];
            }
        }
    }
    
    
    @Override
    public void addEquipment(Equipment eqpmnt) throws ConstructionSiteException {
        
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeEquipment(Equipment eqpmnt) throws ConstructionSiteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Equipment[] getEquipment(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Equipment[] getEquipment(EquipmentStatus es) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Equipment[] getEquipment(EquipmentType et) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Equipment[] getEquipment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
