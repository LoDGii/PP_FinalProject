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

import estgconstroi.Event;
import estgconstroi.Notifier;



/**
 * Classe Notifier
 * @author Bruno
 * @author Diogo
 */
public class NotifierClass implements Notifier{

    /**
     * elementos da classe Notifier
     */
    private Event event;
    
    /**
     * metodo construtor da classe Notifier
     * @param event 
     */
    public NotifierClass(Event event){
        this.event = event;
    }
    
    /**
     * método da notify onde possuirá mensagem, prioridade e o chefe de construção
     * para notificar o utilizador
     * @param event
     * @return 
     */
    @Override
    public boolean notify(Event event) {
        System.out.println("Mensagem: " + this.event.getTitle());
        System.out.println("Data: " + this.event.getDate());
        System.out.println("Prioridade: " + this.event.getPriority().toString());
        System.out.println("Criador do evento: " + this.event.getReporter().getName());
                return true;
    }
    
    

    
}
