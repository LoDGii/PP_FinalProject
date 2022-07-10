/*
* Nome: Bruno Miguel Rodrigues Novais
* Número: 8210333
* Turma: LEI12T1
*
* Nome: Diogo Gomes Cardoso
* Número: 8210193
* Turma: LEI12T1
*/
package pp_finalproject;

import estgconstroi.Employee;
import estgconstroi.enums.EmployeeType;

/**
*This Class provides the parameters needed to create a Employee
* 
* 
* 
 */
public class EmployeeClass extends Employee{
    /**
     * Employees Atributes
     * 
     * 
     * 
     * @param Name String that saves the name of the Employee.
     * @param Type This variable saves the diferent types of Employees (MANAGER, TEAM LEADER OR WORKER).
     * @param status Saves the status of the Employee (WORKING, INACTIVE OR FREE).
     * @param team If It's part of a team the team is saved in here.
     */
    private String Name;
    private EmployeeType Type;
    private EmployeeStatus status;
    private TeamClass team;
    
    /**
     * Constructor Method
     * @param TempName saves the name of the Employee
     * @param TempType saves the Type of the Employee
     */
    public EmployeeClass(String TempName, EmployeeType TempType){
        super();
        this.Name = TempName;
        this.Type = TempType;
        this.status = EmployeeStatus.FREE;
        
    }
    /**
     * Set's the team of the Employee
     * 
     * @param tm 
     */
    public void setTeam(TeamClass tm){
        this.team = tm;
    }
    /**
     * Return's the Team of the Employee.
     * @return Team of the Employee
     */
    public TeamClass getTeam(){
        return this.team;
    }
    
    /**
     * Change's the Status of the Employee
     * 
     * @param stat EmployeeStatus wich the user wants the Employee to have.
     */
    public void setStatus(EmployeeStatus stat){
        this.status = stat;
    }
    /**
     * Return's the Employee Status.
     * @return Employee Status
     */
    public EmployeeStatus getStatus(){
        return this.status;
    }
    /**
     * Constructor Method that only receives params that where inherited from the abstract class
     */
    public EmployeeClass(){
        super();
    }
    
    /**
     * Set's the Employee Name.
     * @param name name of the Employee
     */
    public void setName(String name) {
        this.Name = name;
    }
    
    /**
     * Return's the Name of the Employee.
     * @return Name of the Employee
     */
    @Override
    public String getName() {
        return this4
                .Name;
    }
/**
 * Return's the type of Employee
 * @return Type of Employee
 */
    @Override
    public EmployeeType getType() {
        return this.Type;
    }
    
/**
 * Set's the EmployeeType to the one the User wants.
 * @param et EmployeeType wich the Employee will be changed to.
 */
    @Override
    public void setType(EmployeeType et) {
        this.Type = et;
    }
    
    
}
