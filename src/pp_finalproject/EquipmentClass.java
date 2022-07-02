/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.Equipment;
import estgconstroi.enums.EquipmentStatus;
import estgconstroi.enums.EquipmentType;

/**
 *
 * @author Utilizador
 */
public class EquipmentClass implements Equipment{
    private String Name;
    private EquipmentType Type;
    private EquipmentStatus Status;
    
    
    public EquipmentClass(String TempName, EquipmentType TempType, EquipmentStatus TempStatus){
        this.Name = TempName;
        this.Type = TempType;
        this.Status = TempStatus;
    }
    
    @Override
    public String getName() {
        return this.Name;
    }

    @Override
    public EquipmentType getType() {
        return this.Type;
    }

    @Override
    public EquipmentStatus getStatus() {
        return this.Status;
    }

    @Override
    public void setStatus(EquipmentStatus es) {
        this.Status = es;
    }

}
