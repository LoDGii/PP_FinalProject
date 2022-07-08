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
    private EmployeeStatus status;
    private TeamClass team;
    
    public EmployeeClass(String TempName, EmployeeType TempType){
        super();
        this.Name = TempName;
        this.Type = TempType;
        this.status = EmployeeStatus.FREE;
    }
    
    public void setTeam(TeamClass tm){
        this.team = tm;
    }
    
    public TeamClass getTeam(){
        return this.team;
    }
    
    
    public void setStatus(EmployeeStatus stat){
        this.status = stat;
    }
    
    public EmployeeStatus getStatus(){
        return this.status;
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
