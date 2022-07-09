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
import estgconstroi.ConstructionSiteManager;
import estgconstroi.Employee;
import estgconstroi.Equipment;
import estgconstroi.InsuranceReporter;
import estgconstroi.enums.EventPriority;
import estgconstroi.exceptions.ConstructionSiteManagerException;
import estgconstroi.exceptions.EventManagerException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * Class with all the arguments for the Events menu.
 */
public class EventMenu {
    /**
     * Principal Menu for the events menu
     * 
     * 
     * @param employees array with all the information of the employees from the company
     * @param cons array with all the information of the construction sites.
     * @param equip array with all the equipment of the company
     * @throws IOException
     * @throws InterruptedException
     * @throws ConstructionSiteManagerException
     * @throws EventManagerException 
     */
    public void principalMenu(EmployeeManagerClass employees, ConstructionSiteManagerClass cons, EquipmentsClass equip) throws IOException, InterruptedException, ConstructionSiteManagerException, EventManagerException {
        EventManagerCass events = new EventManagerCass();
        Scanner Read = new Scanner(System.in);
        int Choice;
        do {
            System.out.println("========== MENU EVENT ====================");
            System.out.println("1 - REPORTAR EVENTO");//DONE
            System.out.println("2 - APAGAR EVENTOS QUE ESTÃO NA BASE DE DADOS");//DONE
            System.out.println("3 - RECEBER EVENTOS DA BASE DE DADOS"); //DONE
            System.out.println("0 - SAIR");
            System.out.println("=============================================");
            System.out.println("Escolha: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > 5);
        switch (Choice) {
            case 0:
                break;
            case 1:
                TypeEventMenu(events, employees, cons, equip);
                break;
            case 2:
                removeEventsDb(events);
                break;
            case 3:
                getEventsFromDb(events);
                break;

        }
    }

    public void removeEventsDb(EventManagerCass events) {
        try {
            InsuranceReporter.resetEvents(events.getGroupKey(), events.getGroupName());

        } catch (Exception e) {
            System.out.println("Erro a transferir para JSON e a enviar para a base de dados");
        }
    }

    public void getEventsFromDb(EventManagerCass events) {
        try {
            System.out.println(InsuranceReporter.getEvents(events.getGroupKey(), events.getGroupName()));
        } catch (Exception e) {
            System.out.println("Erro a transferir para JSON e a enviar para a base de dados");

        }
    }

    public void TypeEventMenu(EventManagerCass events, EmployeeManagerClass employees, ConstructionSiteManagerClass cons, EquipmentsClass equip) throws ConstructionSiteManagerException, EventManagerException, IOException, InterruptedException {
        Scanner Read = new Scanner(System.in);
        int choice;
        do {
            System.out.println("========== MENU TYPE EVENT ====================");
            System.out.println("ESCOLHA O TIPO DE EVENTO:");
            System.out.println("1 - ACCIDENT");
            System.out.println("2 - FAILURE");
            System.out.println("3 - INCIDENT");
            System.out.println("0 - SAIR");
            System.out.println("=============================================");
            System.out.println("Escolha: ");
            choice = Read.nextInt();
        } while (choice < 0 || choice > 3);
        switch (choice) {
            case 0:
                principalMenu(employees, cons, equip);
                break;
            case 1:
                CreateAccident(events, employees, cons, equip);
                break;
            case 2:
                CreateFailure(events, employees, cons, equip);
                break;
            case 3:
                CreateIncident(events, employees, cons, equip);
                break;

        }
    }

    public void CreateAccident(EventManagerCass events, EmployeeManagerClass employees, ConstructionSiteManagerClass cons, EquipmentsClass equip) throws ConstructionSiteManagerException, EventManagerException, IOException, InterruptedException {
        String TempDetails, TempNotificacion, TempTitel;
        Employee TempEmployee = null, TempReporter = null;
        EventPriority TempPriority = null;
        ConstructionSite cs = null;
        AccidentClass TempAccident;

        int escolha;
        Scanner Read = new Scanner(System.in);
        System.out.println("TITULO DO EVENTO:");
        TempTitel = Read.next();
        System.out.println("DETALHES DO EVENTO");
        TempDetails = Read.next();
        System.out.println("NOTIFICAÇÃO");
        TempNotificacion = Read.next();
        System.out.println("ESCOLHA A PRIORIDADE \n 1 - HIGH \n 2 - IMMEDIATE \n 3 - NORMAL \n 4 - LOW");
        escolha = Read.nextInt();
        switch (escolha) {
            case 1:
                TempPriority = EventPriority.HIGH;
                break;
            case 2:
                TempPriority = EventPriority.IMMEDIATE;

                break;
            case 3:
                TempPriority = EventPriority.NORMAL;

                break;
            case 4:
                TempPriority = EventPriority.LOW;

                break;
        }
        System.out.println("=====ESCOLHA O EMPREGADO=====");
        if (events.getnumberEvents() != 0) {
            for (int i = 0; i < employees.getEmployees().length; i++) {
                System.out.println("EMPREGADO-" + employees.getEmployees()[i].getName());
            }
            System.out.println("Escolha o nome do empregado");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                TempEmployee = employees.getEmployees()[escolha];
            } else {
                System.out.println("A escolha não é possivel.");
            }
        } else {
            System.out.println("NÃO EXISEM EMPREGADOS");
            System.out.println("=========================");
            TypeEventMenu(events, employees, cons, equip);
        }

        if (events.getnumberEvents() != 0) {
            for (int i = 0; i < employees.getEmployees().length; i++) {
                System.out.println(i + "  EMPREGADO-" + employees.getEmployees()[i].getName());
            }
            System.out.println("Escolha o empregado responsavel");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                TempReporter = employees.getEmployees()[escolha];
            } else {
                System.out.println("A escolha não é possivel.");
            }
        } else {
            System.out.println("NÃO EXISEM EMPREGADOS");
            System.out.println("=========================");
            TypeEventMenu(events, employees, cons, equip);
        }
        if (cons.getNumberOfConstructionSites() != 0) {
            System.out.println("======ESCOLHA O CONSTRUCTION SITE====");
            for (int i = 0; i < cons.getNumberOfConstructionSites(); i++) {
                System.out.println(i + cons.ConstructionSites[i].getName());
            }
            System.out.println("Escolha:");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                cs = cons.ConstructionSites[escolha];
            }
        } else {
            System.out.println("NÃO EXISTEM CONSTRUCTION SITES");
            TypeEventMenu(events, employees, cons, equip);
        }

        TempAccident = new AccidentClass(TempEmployee, TempDetails, TempNotificacion, TempPriority, TempTitel, TempReporter, cs);
        events.reportEvent(TempAccident);
    }

    public void CreateFailure(EventManagerCass events, EmployeeManagerClass employees, ConstructionSiteManagerClass cons, EquipmentsClass equip) throws ConstructionSiteManagerException, EventManagerException, IOException, InterruptedException {
        String TempDetails, TempNotificacion, TempTitel;
        Employee TempReporter = null;
        Equipment TempEquipment = null;
        EventPriority TempPriority = null;
        ConstructionSite cs = null;
        FailureClass TempFailure;

        int escolha;
        Scanner Read = new Scanner(System.in);
        System.out.println("TITULO DO EVENTO:");
        TempTitel = Read.next();
        System.out.println("DETALHES DO EVENTO");
        TempDetails = Read.next();
        System.out.println("NOTIFICAÇÃO");
        TempNotificacion = Read.next();
        System.out.println("ESCOLHA A PRIORIDADE \n 1 - HIGH \n 2 - IMMEDIATE \n 3 - NORMAL \n 4 - LOW");
        escolha = Read.nextInt();
        switch (escolha) {
            case 1:
                TempPriority = EventPriority.HIGH;
                break;
            case 2:
                TempPriority = EventPriority.IMMEDIATE;

                break;
            case 3:
                TempPriority = EventPriority.NORMAL;

                break;
            case 4:
                TempPriority = EventPriority.LOW;

                break;
        }
        System.out.println("=====ESCOLHA O EQUIPAMENTO=====");
        if (equip.getEquipment().length != 0) {
            for (int i = 0; i < equip.getEquipment().length; i++) {
                System.out.println(i + "EQUIPAMENTO-" + equip.getEquipment()[i].getName());
            }
            System.out.println("Escolha o equipamento");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                TempEquipment = equip.getEquipment()[escolha];
            } else {
                System.out.println("A escolha não é possivel.");
            }
        } else {
            System.out.println("NÃO EXISEM EMPREGADOS");
            System.out.println("=========================");
            TypeEventMenu(events, employees, cons, equip);
        }

        if (events.getnumberEvents() != 0) {
            for (int i = 0; i < employees.getEmployees().length; i++) {
                System.out.println(i + "  EMPREGADO-" + employees.getEmployees()[i].getName());
            }
            System.out.println("Escolha o empregado responsavel");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                TempReporter = employees.getEmployees()[escolha];
            } else {
                System.out.println("A escolha não é possivel.");
            }
        } else {
            System.out.println("NÃO EXISEM EMPREGADOS");
            System.out.println("=========================");
            TypeEventMenu(events, employees, cons, equip);
        }
        if (cons.getNumberOfConstructionSites() != 0) {
            System.out.println("======ESCOLHA O CONSTRUCTION SITE====");
            for (int i = 0; i < cons.getNumberOfConstructionSites(); i++) {
                System.out.println(i + cons.ConstructionSites[i].getName());
            }
            System.out.println("Escolha:");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                cs = cons.ConstructionSites[escolha];
            }
        } else {
            System.out.println("NÃO EXISTEM CONSTRUCTION SITES");
            TypeEventMenu(events, employees, cons, equip);
        }

        TempFailure = new FailureClass(TempEquipment, TempDetails, TempNotificacion, TempPriority, TempTitel, TempReporter, cs);
        events.reportEvent(TempFailure);
    }

    public void CreateIncident(EventManagerCass events, EmployeeManagerClass employees, ConstructionSiteManagerClass cons, EquipmentsClass equip) throws ConstructionSiteManagerException, EventManagerException, IOException, InterruptedException {
        String TempDetails, TempNotificacion, TempTitel;
        Employee TempReporter = null;
        EventPriority TempPriority = null;
        ConstructionSite cs = null;
        IncidentClass TempIncident;

        int escolha;
        Scanner Read = new Scanner(System.in);
        System.out.println("TITULO DO EVENTO:");
        TempTitel = Read.next();
        System.out.println("DETALHES DO EVENTO");
        TempDetails = Read.next();
        System.out.println("NOTIFICAÇÃO");
        TempNotificacion = Read.next();
        System.out.println("ESCOLHA A PRIORIDADE \n 1 - HIGH \n 2 - IMMEDIATE \n 3 - NORMAL \n 4 - LOW");
        escolha = Read.nextInt();
        switch (escolha) {
            case 1:
                TempPriority = EventPriority.HIGH;
                break;
            case 2:
                TempPriority = EventPriority.IMMEDIATE;

                break;
            case 3:
                TempPriority = EventPriority.NORMAL;

                break;
            case 4:
                TempPriority = EventPriority.LOW;

                break;
        }

        if (events.getnumberEvents() != 0) {
            for (int i = 0; i < employees.getEmployees().length; i++) {
                System.out.println(i + "  EMPREGADO-" + employees.getEmployees()[i].getName());
            }
            System.out.println("Escolha o empregado responsavel");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                TempReporter = employees.getEmployees()[escolha];
            } else {
                System.out.println("A escolha não é possivel.");
            }
        } else {
            System.out.println("NÃO EXISEM EMPREGADOS");
            System.out.println("=========================");
            TypeEventMenu(events, employees, cons, equip);
        }
        if (cons.getNumberOfConstructionSites() != 0) {
            System.out.println("======ESCOLHA O CONSTRUCTION SITE====");
            for (int i = 0; i < cons.getNumberOfConstructionSites(); i++) {
                System.out.println(i + cons.ConstructionSites[i].getName());
            }
            System.out.println("Escolha:");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                cs = cons.ConstructionSites[escolha];
            }
        } else {
            System.out.println("NÃO EXISTEM CONSTRUCTION SITES");
            TypeEventMenu(events, employees, cons, equip);
        }

        TempIncident = new IncidentClass(cs, TempDetails, TempNotificacion, TempPriority, TempTitel, TempReporter);
        events.reportEvent(TempIncident);
    }

}
