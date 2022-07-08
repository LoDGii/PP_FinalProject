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

import estgconstroi.Accident;

import estgconstroi.ConstructionSite;
import estgconstroi.Employee;
import estgconstroi.Event;
import estgconstroi.enums.EventPriority;

/** 
 * Classe que representa o Accident
 * @author Bruno
 * @author Diogo
 */
public class AccidentClass extends Event implements Accident{

    private Employee employee;
    private String details;
    private String notification;
    
    /**
     * método construtor do AccidentClass
     * @param Employee employee que esteve no accident
     * @param details detalhes ocorridos
     * @param notificationMessage mensagem de notificação
     */
    public AccidentClass(Employee employee, String details, String notification,EventPriority priority, String title, Employee reporter,ConstructionSite constructionSite){
            super(priority, title, reporter, constructionSite);
        this.details = details;
        this.employee = employee;
        this.notification = notification;
    }
    
    /**
     * getter do employee que teve o accident
     * @return employee que teve o acidente
     */
    @Override
    public Employee getEmployee() {
        return this.employee;
       
    }
     /**
     * getter dos detalhes 
     * @return os detalhes
     */
    @Override
    public String getDetails() {
        return this.details;
        
    }
     /**
     * getter da notificação da mensagem
     * @return notificação da mensagem
     */
    @Override
    public String getNotificationMessage() {
       return this.notification;
    }
}
