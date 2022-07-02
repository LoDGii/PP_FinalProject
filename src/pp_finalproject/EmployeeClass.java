/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.Employee;
import estgconstroi.enums.EmployeeType;

/**
 *
 * @author Utilizador
 */
public class EmployeeClass extends Employee{
    private static String Name;
    private EmployeeType Type;
    
    public EmployeeClass(String TempName, EmployeeType TempType){
            super();
        this.Name = TempName;
        this.Type = TempType;
    }
    
    public EmployeeClass(){
        super();
    }
    
    public void setName(String name) {
        this.Name = name;
    }
    
    @Override
    public String getName() {
        return EmployeeClass.Name;
    }

    @Override
    public EmployeeType getType() {
        return this.Type;
    }

    @Override
    public void setType(EmployeeType et) {
        this.Type = et;
    }
    
}
