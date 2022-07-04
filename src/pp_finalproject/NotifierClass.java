/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.Event;
import estgconstroi.Notifier;

public class NotifierClass implements Notifier{

    private Event event;
    
    public NotifierClass(Event event){
        this.event = event;
    }
    
    
    @Override
    public boolean notify(Event event) {
        System.out.println("Mensagem: " + this.event.getTitle());
        System.out.println("Prioridade: " + this.event.getPriority().toString());
        System.out.println("Criador do evento: " + this.event.getReporter().getName());
                return true;
    }
    
}
