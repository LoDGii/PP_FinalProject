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

import estgconstroi.ConstructionSite;
import estgconstroi.Employee;
import estgconstroi.Equipment;
import estgconstroi.Event;
import estgconstroi.Failure;
import estgconstroi.enums.EventPriority;

/**
 *Classe de Failure
 * @author Bruno
 * @author Diogo
 */
public class FailureClass extends Event implements Failure {
/**
 * atributos da classe failure
 */
    private Equipment equipment;
    private String details;
    private String notification;

    /**
     * metodo construtor da classe failure
     * @param equipment equipamento que esta envolvido na falha
     * @param details detalhes da falha
     * @param notification  mensagem de notificação
     * @param priority prioridade da falha
     * @param title titulo da falha
     * @param reporter pessoa que reportou a falha
     * @param TempConstructionSite construction site onde aconteceu a falha
     */
    public FailureClass(Equipment equipment, String details, String notification, EventPriority priority, String title, Employee reporter, ConstructionSite TempConstructionSite) {
        super(priority, title, reporter, TempConstructionSite);
        this.equipment = equipment;
        this.details = details;
        this.notification = notification;
    }
/**
 * metodo que retorna um equipamento da falha
 * @return 
 */
    @Override
    public Equipment getEquipment() {
        return this.equipment;
    }
/**
 * metodo que retorna os detalhes da falha
 * @return 
 */
    @Override
    public String getDetails() {
        return this.details;
    }
/**
 * metodo que retorna a mesagem de notificação
 * @return 
 */
    @Override
    public String getNotificationMessage() {
        return this.notification;
    }

}
