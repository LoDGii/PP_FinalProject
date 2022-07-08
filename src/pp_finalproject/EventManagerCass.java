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
import estgconstroi.EventManager;
import estgconstroi.InsuranceReporter;
import estgconstroi.Notifier;
import estgconstroi.enums.EventPriority;
import estgconstroi.exceptions.EventManagerException;
import java.io.IOException;
import java.time.LocalDate;
import org.json.simple.JSONObject;

/**
 * Classe de EventManager
 *
 * @author Diogo
 * @author José
 */
public class EventManagerCass implements EventManager {
    /**
     * atributos de event manager
     */
    private static String GROUPNAME = "Grupo23";
    private static String GROUPKEY = "biboc236-6022-cola-port-besseki0brad";
    private NotifierClass[] notifie;
    private Event[] event;
    private int numberNotifies;
    private int numberEvents;

    
    /**
     * método construtor
     */
    public EventManagerCass() {
        this.numberNotifies = 0;
        this.numberEvents = 0;
        this.notifie = new NotifierClass[0];
        this.event = new Event[0];
    }

    
    //-------------OUTROS MÉTODOS---------------------------------------
    /**
     * ESTE METODO SERVEM PARA VERIFICAR O TAMANHO DOS ARRAYS E AUMENTALOS SE
     * NECESSARIO
     */
    private void checkNotifierSize() {
        if (this.notifie.length == numberNotifies) {
            NotifierClass[] newarray = new NotifierClass[numberNotifies];
            for (int i = 0; i < numberNotifies; i++) {
                newarray[i] = this.notifie[i];
            }
            this.notifie = new NotifierClass[numberNotifies + 10];
            for (int i = 0; i < numberNotifies; i++) {
                this.notifie[i] = newarray[i];
            }
        }
    }
/**
 * ESTE METODO VERIFICA SE É PRECISO AUMENTAR O ARRAY, SE FOR NECESSARIO AUMENTA
 */
    private void checkEventSize() {
        if (this.event.length == numberEvents) {
            Event[] newarray = new Event[numberEvents];
            for (int i = 0; i < numberEvents; i++) {
                newarray[i] = this.event[i];
            }
            this.event = new Event[numberEvents + 10];
            for (int i = 0; i < numberEvents; i++) {
                this.event[i] = newarray[i];
            }
        }
    }
/**
 * METODO QUE VAI RETORNAR QUANTOS EVENTOS ESTÃO NO ARRAY 
 * 
 * @return int com a quantidade de eventos no array
 */
    public int getnumberEvents(){
        return this.numberEvents;
    }
    
    //---------METODOS OVERRITE---------------------
    /**
     * ESTE METODO ADICIONA UMA NOTIFICAÇÃO
     * 
     * @param ntfr
     * @throws EventManagerException 
     */
    @Override
    public void addNotifier(Notifier ntfr) throws EventManagerException {
        try {
            checkNotifierSize();
            this.notifie[this.numberNotifies++] = (NotifierClass) ntfr;
            System.out.println("Notificação adicionada");
        } catch (Exception e) {
            throw new EventManagerException("Algo de errado aconteceu ao adicionar a Notificação");
        }
    }
/**
 * este metodo remove uma notificação
 * @param ntfr
 * @throws EventManagerException 
 */
    @Override
    public void removeNotifier(Notifier ntfr) throws EventManagerException {
        try {
            boolean equal = false;
            int posicaoarray = -1;
            for (int i = 0; i < this.numberNotifies; i++) {
                if (ntfr.equals(this.notifie[i]) == true) {
                    equal = true;
                    posicaoarray = i;
                }
            }
            if (equal == true) {
                NotifierClass[] array = new NotifierClass[this.notifie.length - 1]; //crio um novo array com menos uma posicao
                int k = 0;//variavel que vai incrementar 
                for (int i = 0; i < this.notifie.length; i++) {//enquanto o i for menor que o tamanho do array
                    if (i != posicaoarray) { // e o i for diferente da posicao recebida
                        array[k] = this.notifie[i];//o array guarda o que tá no array original
                        k++;
                    }
                }
                this.notifie = array; //depois copio a cópia para o original
                this.numberNotifies--;
                System.out.println("Trabalhador foi removido com sucesso");
            }
        } catch (Exception e) {
            throw new EventManagerException("Erro ao remover o trabalhador");
        }
    }
/**
 * este metodo reporta um evento
 * @param event
 * @throws EventManagerException 
 */
    @Override
    public void reportEvent(Event event) throws EventManagerException {
        try {
            checkEventSize();
            this.event[this.numberEvents++] = event;
            System.out.println("Evento reportado com sucesso");
            //meter a notificar aqui também

        } catch (Exception e) {
            throw new EventManagerException("Erro ao fazer o report do evento");
        }
    }
/**
 * este metodo remove todos os eventos que estão no array de eventos
 */
    @Override
    public void removeAllEvents() {
        Event[] array = new Event[0];
        this.event = array;
        System.out.println("Todos os eventos foram removidos com sucesso");
    }
/**
 * este metodo remove um evento de dentro do array que tem eventos
 * @param event
 * @throws EventManagerException 
 */
    @Override
    public void removeEvent(Event event) throws EventManagerException {
        try {
            boolean equal = false;
            int posicaoarray = -1;
            for (int i = 0; i < this.numberEvents; i++) {
                if (event.equals(this.event[i]) == true) {
                    equal = true;
                    posicaoarray = i;
                }
            }
            if (equal == true) {
                Event[] array = new Event[this.event.length - 1]; //crio um novo array com menos uma posicao
                int k = 0;//variavel que vai incrementar 
                for (int i = 0; i < this.event.length; i++) {//enquanto o i for menor que o tamanho do array
                    if (i != posicaoarray) { // e o i for diferente da posicao recebida
                        array[k] = this.event[i];//o array guarda o que tá no array original
                        k++;
                    }
                }
                this.event = array; //depois copio a cópia para o original
                this.numberEvents--;
                System.out.println("Evento removido com sucesso");
            }
        } catch (Exception e) {
            throw new EventManagerException("Erro a remover o evento");
        }
    }
/**
 * este metodo retorna todos os eventos que estão dentro do array event
 * @return 
 */
    public Event[] getAllEvents(){
        return this.event;
    }
    /**
     * este metodo serve para devolver um array de eventos de uma certa prioridade
     * @param ep
     * @return 
     */
    @Override
    public Event[] getEvent(EventPriority ep) {
        int contador = 0;
        for (int i = 0; i < this.numberEvents; i++) {
            if (ep == (this.event[i].getPriority())) {
                contador++;
            }
        }

        Event[] priorityarray = new Event[contador];
        contador = 0;

        for (int i = 0; i < this.numberEvents; i++) {
            if (ep == (this.event[i].getPriority())) {
                priorityarray[contador] = this.event[i];
                contador++;
            }
        }
        return priorityarray;
    }
/**
 * este metodo serve para devolver um array que contem os eventos de uma certa
 * classe Accident, Failure ou Incident
 * @param type
 * @return 
 */
    @Override
    public Event[] getEvent(Class type) {
        int contador = 0;
        for (int i = 0; i < this.numberEvents; i++) {
            if (type == (this.event[i].getClass())) {
                contador++;
            }
        }

        Event[] array = new Event[contador];
        contador = 0;

        for (int i = 0; i < this.numberEvents; i++) {
            if (type == (this.event[i].getClass())) {
                array[contador] = this.event[i];
                contador++;
            }
        }
        return array;
    }
/**
 * este metodo serve para retornar um array com eventos de uma certa data
 * @param ld
 * @return 
 */
    @Override
    public Event[] getEvent(LocalDate ld) {
        int contador = 0;
        for (int i = 0; i < this.numberEvents; i++) {
            if (ld == (this.event[i].getDate())) {
                contador++;
            }
        }
        Event[] array = new Event[contador];
        contador = 0;

        for (int i = 0; i < this.numberEvents; i++) {
            if (ld == (this.event[i].getDate())) {
                array[contador] = this.event[i];
                contador++;
            }
        }
        return array;
    }
/**
 * este metodo retorna todos os eventos entre duas datas selecionadas
 * 
 * @param ld
 * @param ld1
 * @return 
 */
    @Override
    public Event[] getEvent(LocalDate ld, LocalDate ld1) {
        int contador = 0;
        for (int i = 0; i < this.numberEvents; i++) {
            if (ld.compareTo(this.event[i].getDate()) >= 0 && ld1.compareTo(this.event[i].getDate()) <= 0) {
                contador++;
            }
        }

        Event[] array = new Event[contador];
        contador = 0;

        for (int i = 0; i < this.numberEvents; i++) {
            if (ld.compareTo(this.event[i].getDate()) >= 0 && ld1.compareTo(this.event[i].getDate()) <= 0) {
                array[contador] = this.event[i];
                contador++;
            }
        }
        return array;
    }
/**
 * retorna um GroupKey
 * @return 
 */
    public String getGroupKey(){
        return this.getGroupKey();
    }
    /**
     * retorna um GroupName
     * @return 
     */
    public String getGroupName(){
        return this.getGroupName();
    }
    /**
     * 
     * @param event
     * @throws IOException 
     */
    public static void eventToJson(Event event) throws IOException {
        JSONObject eventToJson = new JSONObject();
        eventToJson.put("uuid", event.getUuid());
        eventToJson.put("data", event.getDate());
        eventToJson.put("priority", event.getPriority());
        if (event instanceof AccidentClass) {
            eventToJson.put("eventtype", "Accident");
            eventToJson.put("employeename", ((AccidentClass) event).getEmployee().getName());
        } else if (event instanceof IncidentClass) {
            eventToJson.put("eventtype", "Incident");
        } else if (event instanceof FailureClass) {
            eventToJson.put("eventtype", "Failure");
        }
        eventToJson.put("title", event.getTitle());
        eventToJson.put("constructionsitename", event.getConstructionSite().getName());
        eventToJson.put("details", event.getDetails());
        if (event instanceof AccidentClass) {
            eventToJson.put("employeename", ((AccidentClass) event).getEmployee().getName());
        } else if (event instanceof FailureClass) {
            eventToJson.put("equipment", ((FailureClass) event).getEquipment().getName());

            JSONObject finalProduct = new JSONObject();
            finalProduct.put("groupname", GROUPNAME);
            finalProduct.put("groupkey", GROUPKEY);
            finalProduct.put("event", eventToJson);

            try {
                InsuranceReporter.addEvent(finalProduct.toString());
            } catch (Exception e) {
                throw new IOException(e.getMessage());
            }

            
        }
       
    }

}


