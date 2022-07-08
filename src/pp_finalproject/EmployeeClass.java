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
 *classe do empregado
 * @author Bruno
 * @author Diogo
 */
public class EmployeeClass extends Employee{
    /**
     * atributos de um empregado
     */
    private static String Name;
    private EmployeeType Type;
    private EmployeeStatus status;
    private TeamClass team;
    
    /**
     * metodo construtor de um empregado
     * @param TempName
     * @param TempType 
     */
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
    /**
     * metodo construtor de um empregado sem lhe ter sido atribuido nada
     */
    public EmployeeClass(){
        super();
    }
    
    /**
     * atribui um nome a um empregado
     * @param name 
     */
    public void setName(String name) {
        this.Name = name;
    }
    
    /**
     * retorna o nome de u empregado
     * @return 
     */
    @Override
    public String getName() {
        return EmployeeClass.Name;
    }
/**
 * retorna o tipo de um empregado
 * @return 
 */
    @Override
    public EmployeeType getType() {
        return this.Type;
    }
    
/**
 * atribui um tipo a um empregado
 * @param et 
 */
    @Override
    public void setType(EmployeeType et) {
        this.Type = et;
    }
    
}
