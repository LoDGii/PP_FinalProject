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
import estgconstroi.Event;
import estgconstroi.Incident;
import estgconstroi.enums.EventPriority;

/**
 *classe de incident
 * @author Bruno
 * @author Diogo
 */
public class IncidentClass extends Event implements Incident {

    
    /**
     * atributos de um incident
     */
    private String details;
    private String notificationMessage;
/**
 *  
 * metodo construtor de um incident
 * @param TempConstructionSite local de construção onde acontece o incident
 * @param TempDetails detalhes do incident
 * @param TempNotificationMessage mensagem de notificação do incident
 * @param TempPriority prioridade do incident
 * @param TempTitle titulo do incident
 * @param TempReporter employee que fez report do incident
 */
    public IncidentClass(ConstructionSite TempConstructionSite, String TempDetails, String TempNotificationMessage, EventPriority TempPriority, String TempTitle, Employee TempReporter) {
        super(TempPriority, TempTitle, TempReporter, TempConstructionSite);
        this.details = TempDetails;
        this.notificationMessage = TempNotificationMessage;

    }
/**
 * metodo que retorna os detalhes do incident
 * @return 
 */
    @Override
    public String getDetails() {
        return this.details;
    }
/**
 * metodo que retorna a mensagem de notificação
 * @return 
 */
    @Override
    public String getNotificationMessage() {
        return this.notificationMessage;
    }

}
