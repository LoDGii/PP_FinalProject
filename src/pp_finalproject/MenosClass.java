/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.Accident;
import estgconstroi.ConstructionSite;
import estgconstroi.Employee;
import estgconstroi.Equipment;
import estgconstroi.Equipments;
import estgconstroi.Event;
import estgconstroi.InsuranceReporter;
import estgconstroi.Team;
import estgconstroi.enums.EmployeeType;
import estgconstroi.enums.EventPriority;
import estgconstroi.exceptions.ConstructionSiteException;
import estgconstroi.exceptions.ConstructionSiteManagerException;
import estgconstroi.exceptions.EventManagerException;
import estgconstroi.exceptions.TeamException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Utilizador
 */
public class MenosClass {

    private ConstructionSiteManagerClass Constructions = new ConstructionSiteManagerClass();
    private TeamManagerClass Teams = new TeamManagerClass();
    private EquipmentsClass ListOfEquipments = new EquipmentsClass();
    private EmployeeManagerClass Employees = new EmployeeManagerClass();
    private EventManagerCass Events = new EventManagerCass();

    public void PrincipalMenu() throws ConstructionSiteManagerException {
        try {
            Scanner Read = new Scanner(System.in);
            int choice;
            do {
                System.out.println("========== MENU PRINCIPAL ==========");
                System.out.println("1 - MENU DE CONSTRUÇÕES");
                System.out.println("2 - MENU DE EVENTOS");
                System.out.println("3 - MENU DE TEAMS");
                System.out.println("4 - MENU DE EMPLOYESS");
                System.out.println("0 - SAIR");
                System.out.println("====================================");
                System.out.println("Escolha: ");
                choice = Read.nextInt();
            } while (choice < 0 || choice > 4);
            switch (choice) {
                case 0:
                    break;
                case 1:
                    ConstructionMenu();
                    break;
                case 2:
                    EventMenu();
                    break;
                case 3:
                    TeamsMenu();
                    break;
                case 4:
                    EmployeesMenu();
                    break;

            }
        } catch (Exception o) {
            System.out.println(o.getMessage());
            PrincipalMenu();

        }

    }

    public void TeamsMenu() throws ConstructionSiteManagerException, ConstructionSiteException {
        Scanner Read = new Scanner(System.in);
        int choice;
        do {
            System.out.println("========== MENU DE EQUIPAS ==========");
            System.out.println("1 - CRIAR NOVA EQUIPA");
            System.out.println("2 - LISTAR EQUIPAS INATIVAS");
            System.out.println("3 - LISTAR EQUIPAS EM ATIVIDADE");
            System.out.println("4 - EDITAR EQUIPA");
            System.out.println("0 - VOLTAR AO MENU PRINCIPAL");
            System.out.println("==========================================");
            choice = Read.nextInt();
        } while (choice < 0 || choice > 4);
        switch (choice) {
            case 0:
                PrincipalMenu();
                break;
            case 1:
                createNewTeam();
                TeamsMenu();
                break;
            case 2:
                System.out.println("========== LISTA DE EQUIPAS INATIVAS ==========");
                showTeamsByStatus(TeamStatus.INACTIVE);
                System.out.println("===============================================");
                PrincipalMenu();
                break;
            case 3:
                System.out.println("========== LISTA DE EQUIPAS ATIVAS ==========");
                showTeamsByStatus(TeamStatus.WORKING);
                System.out.println("===============================================");
                PrincipalMenu();
                break;
            case 4:
                editTeam();
                break;
        }
    }
    
    public void editTeam() throws ConstructionSiteManagerException, ConstructionSiteException {
        Scanner Read = new Scanner(System.in);
        int Choice;
        int Index_Team = 0;
        int NumberOfTeams = this.Teams.NumberOfTeams;
        do {
            System.out.println("========== LISTA DE EQUIPAS ==========");
            showAllTeams();
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > NumberOfTeams);
        switch (Choice) {
            case 0:
                TeamsMenu();
                break;
        }
        Index_Team = Choice;
        Index_Team--;
        do {
            System.out.println("========== EDITAR EQUIPA ==========");
            System.out.println("1 - DEFINIR LIDER");//Done
            System.out.println("2 - ADICIONAR EQUIPAMENTOS");
            System.out.println("3 - ALTERAR NOME");
            System.out.println("4 - ADICIONAR FUNCIONÁRIOS");//Done
            System.out.println("5 - REMOVER FUNCIONÁRIOS");//Done
            System.out.println("0 - VOLTAR PARA O MENU ANTERIOR");//Done
            System.out.println("===================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > 5);
        switch (Choice) {
            case 0:
                TeamsMenu();
                break;
            case 1:
                setLeader(Index_Team);
                break;
            case 2:
                //addEquipments(Index_Team, Type);
                break;
            case 3:
                changeTeamName(Index_Team);
                break;
            case 4:
                addEmployee(Index_Team);
                break;
            case 5:
                removeEmployee(Index_Team);
                break;
        }

    }

    public void changeTeamName(int Index) throws ConstructionSiteManagerException, ConstructionSiteException{
        Scanner Read = new Scanner(System.in);
        String TempName;
        System.out.println("NOME: ");
        TempName = Read.next();
        this.Teams.setName(Index, TempName);
        editTeam();
    }
    
    
    public void removeEmployee(int Index) throws ConstructionSiteManagerException, ConstructionSiteException {
        Scanner Read = new Scanner(System.in);
        int Choice, Index_Emp;
        TeamClass[] teams = this.Teams.getTeams();
        TeamClass team = teams[Index];
        Employee[] employees =  team.getEmployees();
        do{
        for(int i = 0;i < employees.length;i++){
            System.out.println(i + 1 + " - " + employees[i].getName());
        }
        System.out.println("0 - VOLTAR AO MENU ANTERIOR");
        System.out.println("==============================================");
        System.out.println("OPÇÃO: ");
        Choice = Read.nextInt();
        }while(Choice < 0 || Choice > employees.length);
        switch(Choice){
            case 0:
                editTeam();
                break;
        }
        this.Teams.removeEmployee(Index, employees[Choice - 1]);
        Index_Emp = this.Employees.getEmployee(employees[Choice - 1]);
        this.Employees.setEmployeeStatus(Index_Emp, EmployeeStatus.FREE);
    }

    public void addEmployee(int Index) throws ConstructionSiteManagerException, ConstructionSiteException {
        Scanner Read = new Scanner(System.in);
        int Choice;
        int[] Index_Employees;
        do {
            Index_Employees = showEmployeesByStatus(EmployeeStatus.FREE);
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");
            System.out.println("===========================================");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > Index_Employees.length);
        switch (Choice) {
            case 0:
                editTeam();
                break;
        }
        EmployeeClass[] emp = this.Employees.getEmployees();
        TeamClass[] teams = this.Teams.getTeams();
        this.Employees.setTeam(Index_Employees[Choice - 1], teams[Index]);
        this.Employees.setEmployeeStatus(Index_Employees[Choice - 1], EmployeeStatus.WORKING);
        this.Teams.addEmployee(emp[Index_Employees[Choice - 1]], Index);
    }

    public int[] showEmployeesByStatus(EmployeeStatus stat) {
        EmployeeClass[] emp = this.Employees.getEmployees();
        int[] Index = new int[emp.length];
        int k = 0;
        System.out.println("========== LISTA DE FUNCIONÁRIOS ==========");
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getStatus() == stat) {
                System.out.println(k + 1 + " - " + emp[i].getName());
                Index[k] = i;
                k++;
            }
        }

        int[] FakeArray = new int[k];
        System.arraycopy(Index, 0, FakeArray, 0, k);
        return FakeArray;
    }

    public void setLeader(int Index) throws ConstructionSiteManagerException, TeamException, ConstructionSiteException {
        int[] Index_Teams;
        Scanner Read = new Scanner(System.in);
        int Choice;
        do {
            System.out.println("========== LISTA DE LIDERES ==========");
            Index_Teams = showTeamsByType(EmployeeType.TEAM_LEADER);
            System.out.println("0 - VOLTAR ATRÁS");
            System.out.println("======================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > Index_Teams.length);
        switch (Choice) {
            case 0:
                TeamsMenu();
                break;
            default:
                EmployeeClass emp = this.Employees.getEmployee(Index);
                this.Teams.setLeader(emp, Index);
        }
    }

    public int[] showTeamsByType(EmployeeType type) {
        EmployeeClass[] emp = this.Employees.getEmployees();
        int k = 0;
        int[] index = new int[emp.length];
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getType() == type) {
                System.out.println(k + 1 + " - " + emp[i].getName());
                index[k] = i;
                k++;
            }

        }
        int[] FakeArray = new int[k];
        System.arraycopy(index, 0, FakeArray, 0, k);
        return FakeArray;
    }

    public void showAllTeams() {
        TeamClass[] teams = this.Teams.getTeams();
        int[] Index = new int[teams.length];
        int k = 0;
        for (int i = 0; i < teams.length; i++) {
            System.out.println(i + 1 + " - " + teams[i].getName());

        }

    }

    public void showTeamsByStatus(TeamStatus status) {
        TeamClass[] teams = this.Teams.getTeams();
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].getStatus() == status) {
                System.out.println(teams[i].getName() + " - " + teams[i].getLeader());
            }
        }
    }

    public void createNewTeam() {
        String TempName;
        Scanner Read = new Scanner(System.in);
        System.out.println("NOME: ");
        TempName = Read.next();
        TeamClass team = new TeamClass(TempName);
        this.Teams.add(team);
    }

    public void EmployeesMenu() throws ConstructionSiteManagerException {
        Scanner Read = new Scanner(System.in);
        int Choice;
        do {
            System.out.println("========== MENU DE FUNCIONÁRIOS ==========");
            System.out.println("1 - CRIAR FUNCIONÁRIO");
            System.out.println("2 - MOSTRAR LISTA DE FUNCIONÁRIOS");
            System.out.println("3 - EDITAR FUNCIONÁRIO");
            System.out.println("0 - VOLTAR AO MENU PRINCIPAL");
            System.out.println("==========================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > 3);
        switch (Choice) {
            case 0:
                PrincipalMenu();
                break;
            case 1:
                addEmployeeMenu();
                break;
            case 2:
                System.out.println("========== LISTA DE FUNCIONÁRIOS ==========");
                showEmployees();
                System.out.println("===========================================");
                break;
            case 3:
                editEmployee();
                break;
        }
        PrincipalMenu();
    }

    public void editEmployee() throws ConstructionSiteManagerException {
        Employee[] emp = this.Employees.getEmployees();
        Scanner Read = new Scanner(System.in);
        int Choice, Index;
        do {
            System.out.println("========== LISTA DE FUNCIONÁRIOS ==========");
            for (int i = 0; i < this.Employees.getNumebrOfEmployees(); i++) {
                System.out.println(i + 1 + " - " + emp[i].getName());
            }
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");
            System.out.println("============================================");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > emp.length);
        switch (Choice) {
            case 0:
                EmployeesMenu();
                break;
        }
        Index = Choice;
        do {
            System.out.println("========== MENU DE EDIÇÃO DE FUNCIONÁRIOS ==========");
            System.out.println("1 - ALTERAR NOME");
            System.out.println("2 - ALTERAR FUNÇÃO");
            System.out.println("0 - VOLTAR AO MENU DE FUNCIONÁRIOS");
            System.out.println("=====================================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > 2);
        switch (Choice) {
            case 0:
                PrincipalMenu();
                break;
            case 1:
                String TempName;
                System.out.println("NOVO NOME: ");
                TempName = Read.next();
                this.Employees.setName(TempName, Index);
                EmployeesMenu();
            case 2:
                EmployeeType TempType = null;
                do {
                    System.out.println("========== ESCOLHA O TIPO ==========");
                    System.out.println("1 - TRABALHADOR");
                    System.out.println("2 - GESTOR");
                    System.out.println("3 - LIDER DE EQUIPA");
                    System.out.println("====================================");
                    System.out.println("OPÇÃO: ");
                    Choice = Read.nextInt();
                } while (Choice < 1 || Choice > 3);
                switch (Choice) {
                    case 1:
                        TempType = EmployeeType.WORKER;
                        break;
                    case 2:
                        TempType = EmployeeType.MANAGER;
                        break;
                    case 3:
                        TempType = EmployeeType.TEAM_LEADER;
                        break;
                }
                this.Employees.setType(TempType, Index);
                EmployeesMenu();
                break;
        }
    }

    public void showEmployees() {
        Employee[] emp = this.Employees.getEmployees();
        for (int i = 0; i < this.Employees.getNumebrOfEmployees(); i++) {
            System.out.println(emp[i].getName() + " - " + emp[i].getType());
        }
    }

    public void addEmployeeMenu() throws ConstructionSiteManagerException {
        Scanner Read = new Scanner(System.in);
        String TempName;
        EmployeeType TempType = EmployeeType.WORKER;
        int Choice;
        System.out.println("NOME DO FUNCIONÁRIO: ");
        TempName = Read.next();
        do {
            System.out.println("========== ESCOLHA O TIPO ==========");
            System.out.println("1 - TRABALHADOR");
            System.out.println("2 - GESTOR");
            System.out.println("3 - LIDER DE EQUIPA");
            System.out.println("====================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 1 || Choice > 3);
        switch (Choice) {
            case 1:
                TempType = EmployeeType.WORKER;
                break;
            case 2:
                TempType = EmployeeType.MANAGER;
                break;
            case 3:
                TempType = EmployeeType.TEAM_LEADER;
                break;
        }
        EmployeeClass emp = new EmployeeClass(TempName, TempType);
        this.Employees.add(emp);
        EmployeesMenu();
    }

    public void ConstructionMenu() throws ConstructionSiteManagerException {
        try {
            Scanner Read = new Scanner(System.in);
            int choice;
            do {
                System.out.println("========== MENU DE CONSTRUÇÕES ==========");
                System.out.println("1 - CRIAR NOVO LOCAL DE CONSTRUÇÃO");
                System.out.println("2 - INFORMAÇÃO SOBRE TODAS AS CONSTRUÇÕES");
                System.out.println("3 - REMOVER CONSTRUÇÃO");
                System.out.println("4 - EDITAR UMA CONSTRUÇÃO");
                System.out.println("0 - VOLTAR AO MENU PRINCIPAL");
                System.out.println("==========================================");
                choice = Read.nextInt();
            } while (choice < 0 || choice > 4);
            switch (choice) {
                case 0:
                    PrincipalMenu();
                    break;
                case 1:
                    CreateConstructionSite();
                    break;
                case 2:
                    this.Constructions.showAllConstructionSites();
                    ConstructionMenu();
                    break;
                case 3:
                    RemoveConstructionMenu();
                    break;
                case 4:
                    EditConstructions();
                    break;
            }
        } catch (Exception o) {
            System.out.println(o.getMessage());
            ConstructionMenu();
        }
    }

    public void EventMenu() throws ConstructionSiteManagerException, EventManagerException {
        Scanner Read = new Scanner(System.in);
        int choice;
        do {
            System.out.println("========== MENU EVENT ====================");
            System.out.println("1 - REPORTAR EVENTO");
            System.out.println("2 - OBTER EVENTOS POR PRIORIDADE");
            System.out.println("3 - OBTER EVENTOS POR TIPO");
            System.out.println("4 - OBTER EVENTOS POR DATA");
            System.out.println("5 - OBTER EVENTOS NUM INTERVALO DE DATAS");
            System.out.println("6 - REMOVER EVENTO");
            System.out.println("7 - REMOVER TODOS OS EVENTOS");
            System.out.println("8 - APAGAR EVENTOS QUE ESTÃO NA BASE DE DADOS");
            System.out.println("9 - RECEBER EVENTOS DA BASE DE DADOS");
            System.out.println("0 - SAIR");
            System.out.println("=============================================");
            System.out.println("Escolha: ");
            choice = Read.nextInt();
        } while (choice < 0 || choice > 9);
        switch (choice) {
            case 0:
                PrincipalMenu();
                break;
            case 1:
                TypeEventMenu();
                EventMenu();
                break;
            case 2:
                ReportEventsPrio();
                EventMenu();
                break;
            case 3:
                ReportEventsType();
                EventMenu();
                break;
            case 4:
                ReportEventsDate();
                EventMenu();
                break;
            case 5:
                ReportEventsTwoDate();
                EventMenu();
                break;
            case 6:
                RemoveEvent();
                EventMenu();
                break;
            case 7:
                removerAllEvents();
                EventMenu();
                break;
            case 8:
                apagarEventsBD();
                EventMenu();
                break;
            case 9:
                receberEventsBD();
                EventMenu();
                break;
        }
    }

    public void receberEventsBD() {
        try {
            System.out.println(InsuranceReporter.getEvents(this.Events.getGroupKey(), this.Events.getGroupName()));
        } catch (Exception e) {
            System.out.println("Erro a transferir para JSON e a enviar para a base de dados");

        }
    }

    public void apagarEventsBD() {
        try {
            InsuranceReporter.resetEvents(this.Events.getGroupKey(), this.Events.getGroupName());

        } catch (Exception e) {
            System.out.println("Erro a transferir para JSON e a enviar para a base de dados");
        }
    }

    public void removerAllEvents() {
        if (this.Events.getnumberEvents() == 0) {
            System.out.println("Não existem eventos para remover");
        } else {
            this.Events.removeAllEvents();
            System.out.println("Todos os eventos removidos");
        }
    }

    public void RemoveEvent() {
        int escolher;
        Scanner Read = new Scanner(System.in);
        if (this.Events.getnumberEvents() == 0) {
            System.out.println("Não existem eventos para remover");
        } else {
            try {
                System.out.println("Escolha o evento que deseja remover:");
                do {
                    for (int i = 0; i < this.Events.getnumberEvents(); i++) {
                        System.out.println((i + 1) + " - " + this.Events.getAllEvents()[i].getTitle());
                    }
                    escolher = Read.nextInt();
                } while (escolher < 1 || escolher > this.Events.getnumberEvents());

                this.Events.removeEvent(this.Events.getAllEvents()[escolher - 1]);
            } catch (EventManagerException e) {
                System.out.println("Erro ao reportar");
            }
        }
    }

    public void ReportEventsTwoDate() {
        try {
            Scanner Read = new Scanner(System.in);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println("Introduza a primeira data que deseja procurar no seguinte formato (dd/mm/yyyy): ");
            String data = Read.next();
            System.out.println("Introduza a segunda data que deseja procurar no seguinte formato (dd/mm/yyyy): ");
            String data2 = Read.next();
            LocalDate localDate = LocalDate.parse(data, formatter);
            LocalDate localDate1 = LocalDate.parse(data2, formatter);
            Event[] array = this.Events.getEvent(localDate, localDate1);
            if (array.length == 0) {
                System.out.println("Não existem eventos entre essas datas");
            } else {
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i].toString());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void ReportEventsDate() {
        try {
            Scanner Read = new Scanner(System.in);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println("Introduza a data que deseja procurar no seguinte formato (dd/mm/yyyy): ");
            String data = Read.next();
            LocalDate localDate = LocalDate.parse(data, formatter);
            Event[] array = this.Events.getEvent(localDate);
            if (array.length == 0) {
                System.out.println("Não existem eventos nessa data");
            } else {
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i].toString());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void ReportEventsType() throws ConstructionSiteManagerException, EventManagerException {
        try {
            Scanner Read = new Scanner(System.in);
            int evento2;
            do {
                System.out.println("Indique o tipo de evento que deseja procurar:\n1 - Acidente\n2 - Incidente\n3 - Falha");
                evento2 = Read.nextInt();
            } while (evento2 < 1 || evento2 > 3);
            for (int i = 0; i < this.Events.getnumberEvents(); i++) {
                if (evento2 == 1) {
                    if (this.Events.getAllEvents()[i] instanceof AccidentClass) {
                        System.out.println(this.Events.getAllEvents()[i].toString());
                    }
                }
                if (evento2 == 2) {
                    if (this.Events.getAllEvents()[i] instanceof IncidentClass) {
                        System.out.println(this.Events.getAllEvents()[i].toString());
                    }
                }
                if (evento2 == 3) {
                    if (this.Events.getAllEvents()[i] instanceof FailureClass) {
                        System.out.println(this.Events.getAllEvents()[i].toString());
                    }
                }
            }
        } catch (Exception o) {
            System.out.println("Não existe eventos");
            EventMenu();
        }
    }

    public void ReportEventsPrio() {
        Scanner Read = new Scanner(System.in);
        int evento;
        EventPriority prioridade = null;

        do {
            System.out.println("Indique a prioridade que deseja procurar:\n1 - IMMEDIATE \n2 - HIGH\n3 - NORMAL\n4- LOW");
            evento = Read.nextInt();
        } while (evento < 1 || evento > 4);
        if (evento == 1) {
            prioridade = prioridade.IMMEDIATE;
        }
        if (evento == 2) {
            prioridade = prioridade.HIGH;
        }
        if (evento == 3) {
            prioridade = prioridade.NORMAL;
        }
        if (evento == 4) {
            prioridade = prioridade.LOW;
        }

        Event[] arrayprio = this.Events.getEvent(prioridade);
        if (arrayprio.length == 0) {
            System.out.println("Não existem eventos do tipo " + prioridade);
        } else {
            System.out.println("LISTA DE EVENTOS COM A PRIORIDADE " + prioridade);
            for (int i = 0; i < arrayprio.length; i++) {
                System.out.println(arrayprio[i].toString());
            }
        }
    }

    public void TypeEventMenu() throws ConstructionSiteManagerException, EventManagerException {
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
                EventMenu();
                break;
            case 1:
                CreateAccident();
                break;
            case 2:
                CreateFailure();
                break;
            case 3:
                CreateIncident();
                break;

        }
    }

    public void CreateAccident() throws ConstructionSiteManagerException, EventManagerException {
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
        if (this.Events.getnumberEvents() != 0) {
            for (int i = 0; i < this.Employees.getEmployees().length; i++) {
                System.out.println("EMPREGADO-" + this.Employees.getEmployees()[i].getName());
            }
            System.out.println("Escolha o nome do empregado");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                TempEmployee = this.Employees.getEmployees()[escolha];
            } else {
                System.out.println("A escolha não é possivel.");
            }
        } else {
            System.out.println("NÃO EXISEM EMPREGADOS");
            System.out.println("=========================");
            TypeEventMenu();
        }

        if (this.Events.getnumberEvents() != 0) {
            for (int i = 0; i < this.Employees.getEmployees().length; i++) {
                System.out.println(i + "  EMPREGADO-" + this.Employees.getEmployees()[i].getName());
            }
            System.out.println("Escolha o empregado responsavel");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                TempReporter = this.Employees.getEmployees()[escolha];
            } else {
                System.out.println("A escolha não é possivel.");
            }
        } else {
            System.out.println("NÃO EXISEM EMPREGADOS");
            System.out.println("=========================");
            TypeEventMenu();
        }
        if (this.Constructions.getNumberOfConstructionSites() != 0) {
            System.out.println("======ESCOLHA O CONSTRUCTION SITE====");
            for (int i = 0; i < this.Constructions.getNumberOfConstructionSites(); i++) {
                System.out.println(i + this.Constructions.ConstructionSites[i].getName());
            }
            System.out.println("Escolha:");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                cs = this.Constructions.ConstructionSites[escolha];
            }
        } else {
            System.out.println("NÃO EXISTEM CONSTRUCTION SITES");
            TypeEventMenu();
        }

        TempAccident = new AccidentClass(TempEmployee, TempDetails, TempNotificacion, TempPriority, TempTitel, TempReporter, cs);
        Events.reportEvent(TempAccident);
    }

    public void CreateFailure() throws ConstructionSiteManagerException, EventManagerException {
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
        if (this.ListOfEquipments.getEquipment().length != 0) {
            for (int i = 0; i < this.ListOfEquipments.getEquipment().length; i++) {
                System.out.println(i + "EQUIPAMENTO-" + this.ListOfEquipments.getEquipment()[i].getName());
            }
            System.out.println("Escolha o equipamento");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                TempEquipment = this.ListOfEquipments.getEquipment()[escolha];
            } else {
                System.out.println("A escolha não é possivel.");
            }
        } else {
            System.out.println("NÃO EXISEM EMPREGADOS");
            System.out.println("=========================");
            TypeEventMenu();
        }

        if (this.Events.getnumberEvents() != 0) {
            for (int i = 0; i < this.Employees.getEmployees().length; i++) {
                System.out.println(i + "  EMPREGADO-" + this.Employees.getEmployees()[i].getName());
            }
            System.out.println("Escolha o empregado responsavel");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                TempReporter = this.Employees.getEmployees()[escolha];
            } else {
                System.out.println("A escolha não é possivel.");
            }
        } else {
            System.out.println("NÃO EXISEM EMPREGADOS");
            System.out.println("=========================");
            TypeEventMenu();
        }
        if (this.Constructions.getNumberOfConstructionSites() != 0) {
            System.out.println("======ESCOLHA O CONSTRUCTION SITE====");
            for (int i = 0; i < this.Constructions.getNumberOfConstructionSites(); i++) {
                System.out.println(i + this.Constructions.ConstructionSites[i].getName());
            }
            System.out.println("Escolha:");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                cs = this.Constructions.ConstructionSites[escolha];
            }
        } else {
            System.out.println("NÃO EXISTEM CONSTRUCTION SITES");
            TypeEventMenu();
        }

        TempFailure = new FailureClass(TempEquipment, TempDetails, TempNotificacion, TempPriority, TempTitel, TempReporter, cs);
        Events.reportEvent(TempFailure);
    }

    public void CreateIncident() throws ConstructionSiteManagerException, EventManagerException {
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

        if (this.Events.getnumberEvents() != 0) {
            for (int i = 0; i < this.Employees.getEmployees().length; i++) {
                System.out.println(i + "  EMPREGADO-" + this.Employees.getEmployees()[i].getName());
            }
            System.out.println("Escolha o empregado responsavel");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                TempReporter = this.Employees.getEmployees()[escolha];
            } else {
                System.out.println("A escolha não é possivel.");
            }
        } else {
            System.out.println("NÃO EXISEM EMPREGADOS");
            System.out.println("=========================");
            TypeEventMenu();
        }
        if (this.Constructions.getNumberOfConstructionSites() != 0) {
            System.out.println("======ESCOLHA O CONSTRUCTION SITE====");
            for (int i = 0; i < this.Constructions.getNumberOfConstructionSites(); i++) {
                System.out.println(i + this.Constructions.ConstructionSites[i].getName());
            }
            System.out.println("Escolha:");
            escolha = Read.nextInt();
            if (escolha >= 0) {
                cs = this.Constructions.ConstructionSites[escolha];
            }
        } else {
            System.out.println("NÃO EXISTEM CONSTRUCTION SITES");
            TypeEventMenu();
        }

        TempIncident = new IncidentClass(cs, TempDetails, TempNotificacion, TempPriority, TempTitel, TempReporter);
        Events.reportEvent(TempIncident);
    }

    public void CreateConstructionSite() throws ConstructionSiteManagerException {
        try {
            String TempName, TempLocation, TempPermit, TempDate;
            ConstructionSiteClass cs;
            Scanner Read = new Scanner(System.in);
            System.out.println("NOME DA CONSTRUÇÃO: ");
            TempName = Read.next();
            System.out.println("LOCALIZAÇÃO: ");
            TempLocation = Read.next();
            System.out.println("PERMIT: ");
            TempPermit = Read.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println("DATA DE EXPIRAÇÃO (dd/mm/yyyy): ");
            TempDate = Read.next();
            LocalDate localDate = LocalDate.parse(TempDate, formatter);
            cs = new ConstructionSiteClass(TempName, TempLocation, localDate, TempPermit);
            this.Constructions.add(cs);
            ConstructionMenu();
        } catch (Exception o) {
            System.out.println(o.getMessage());
            ConstructionMenu();
        }

    }

    public void RemoveConstructionMenu() throws ConstructionSiteManagerException {
        try {
            int NumberOfConstructions = this.Constructions.getNumberOfConstructionSites();
            Scanner Read = new Scanner(System.in);
            int Choice;
            do {
                System.out.println("========== LISTA DE COSNTRUÇÕES ==========");
                ListOfTeamsMenu();
                System.out.println("0 - VOLTAR ATRÁS");
                System.out.println("==========================================");
                System.out.println("OPÇÃO: ");
                Choice = Read.nextInt();
            } while (Choice < 0 || Choice > NumberOfConstructions);
            switch (Choice) {
                case 0:
                    ConstructionMenu();
                default:
                    this.Constructions.remove(Choice);
            }
            ConstructionMenu();
        } catch (Exception o) {
            System.out.println(o.getMessage());
            ConstructionMenu();
        }
    }

    public void EditConstructions() throws ConstructionSiteManagerException, ConstructionSiteException {
        Scanner Read = new Scanner(System.in);
        String TempDate;
        int NumberOfConstructions = this.Constructions.getNumberOfConstructionSites();
        ConstructionSiteClass[] ConstructionSites = this.Constructions.getConstructionSites();
        int Index_cs, Choice;
        do {
            System.out.println("========== LISTA DE CONSTRUÇÕES ==========");
            ListOfTeamsMenu();
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");
            System.out.println("==========================================");
            System.out.println("OPÇÃO: ");
            Index_cs = Read.nextInt();
        } while (Index_cs < 0 || Index_cs > NumberOfConstructions + 1);
        switch (Index_cs) {
            case 0:
                PrincipalMenu();
                break;
            default:
                break;
        }
        Index_cs--;
        System.out.println("========== EDITAR CONSTRUÇÃO ==========");
        System.out.println("1 - EQUIPAS");
        System.out.println("2 - EQUIPAMENTOS");
        System.out.println("3 - DEFINIR RESPONSAVEL");
        System.out.println("4 - RESPONSAVEL PELA CONSTRUÇÃO");
        System.out.println("5 - VERIFICAR VALIDADE DA CONSTRUÇÃO");
        System.out.println("6 - ALTERAR PERMIT");
        System.out.println("7 - VER DATA DE TERMINO DA CONSTRUÇÃO");
        System.out.println("0 - VOLTAR ATRÁS");
        System.out.println("=======================================");
        System.out.println("OPÇÃO: ");
        Choice = Read.nextInt();
        switch (Choice) {
            case 0:
                ConstructionMenu();
            case 1:
                TeamMenu(Index_cs);
            case 2:
                EquipmentsMenuCs(Index_cs);
            case 3:
                Employee[] Managers = this.Employees.getManagers();
                do {
                    System.out.println("========== LISTA DE MANAGERS ==========");
                    for (int i = 0; i < Managers.length; i++) {
                        System.out.println(i + 1 + " - " + Managers[i].getName());
                    }
                    System.out.println("=======================================");
                    Choice = Read.nextInt();
                } while (Choice < 0 || Choice > Managers.length);
                switch (Choice) {
                    case 0:
                        EditConstructions();
                    default:
                        break;
                }
                ConstructionSites[Index_cs].setResponsible(Managers[Choice - 1]);
                System.out.println("RESPONSAVEL DEFINIDO COM SUCESSO!");
                EditConstructions();

            case 4:
                System.out.println("RESPONSAVEL PELA CONSTRUÇÃO: " + ConstructionSites[Index_cs].getResponsible().getName());
                EditConstructions();
            case 5:
                boolean isValid = ConstructionSites[Index_cs].isValid();
                if (isValid == true) {
                    System.out.println("CONSTRUÇÃO VALIDA!");

                } else {
                    System.out.println("CONSTRUÇÃO NÃO É VALIDA!");
                }
                EditConstructions();
            case 6:
                System.out.println("Permit: ");
                String TempPermit = Read.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.println("DATA DE EXPIRAÇÃO (dd/mm/yyyy): ");
                TempDate = Read.next();
                LocalDate localDate = LocalDate.parse(TempDate, formatter);
                ConstructionSites[Index_cs].setPermit(TempPermit, localDate);
            case 7:
                System.out.println("DATA DE TERMINO DE CONSTRUÇÃO: " + ConstructionSites[Index_cs].getEndDate());
                EditConstructions();
        }

    }

    public void EquipmentsMenuCs(int Index) throws ConstructionSiteManagerException, ConstructionSiteException {
        Scanner Read = new Scanner(System.in);
        int Choice;
        do {
            System.out.println("========= MENU DE EQUIPAMENTOS ==========");
            System.out.println("1 - LISTA DE EQUIPAMENTOS DESTA CONSTRUÇÃO");
            System.out.println("2 - ADICIONAR EQUIPAMENTOS");
            System.out.println("3 - REMOVER EQUIPAMENTOS");
            System.out.println("0 - MENU ANTERIOR");
            System.out.println("==========================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > 3);
        switch (Choice) {
            case 0:
                EditConstructions();
                break;
            case 1:

                do {
                    System.out.println("========== LISTA DE EQUIPAMENTOS DESTA CONSTRUÇÃO ==========");
                    ListEquipmentsCs(Index);
                    System.out.println("0 - VOLTAR AO MENU ANTERIOR");
                    System.out.println("============================================================");
                    System.out.println("OPÇÃO: ");
                    Choice = Read.nextInt();
                } while (Choice != 0);
                EquipmentsMenuCs(Index);
                break;
            case 2:
                addEquipmentCs(Index);
                EquipmentsMenuCs(Index);
                break;
            case 3:
                removeEquipmentCs(Index);
                EquipmentsMenuCs(Index);
        }

    }

    public void removeEquipmentCs(int Index) throws ConstructionSiteException, ConstructionSiteManagerException {
        Scanner Read = new Scanner(System.in);
        int Choice;
        ConstructionSiteClass[] Constructions = this.Constructions.getConstructionSites();
        Equipments ListOfEquipments = Constructions[Index].getEquipments();
        Equipment[] Equipments = ListOfEquipments.getEquipment();
        do {
            System.out.println("========== LISTA DE EQUIPAMENTOS DISPONIVEIS PARA REMOÇÃO ==========");
            ListEquipmentsCs(Index);
            System.out.println("0 - VOLTAR PARA O MENU ANTERIOR");
            System.out.println("====================================================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > this.Constructions.ConstructionSites[Index].getEquipments().getEquipment().length);
        switch (Choice) {
            case 0:
                EquipmentsMenuCs(Index);
        }
        this.ListOfEquipments.addEquipment(Equipments[Choice - 1]);
        this.Constructions.ConstructionSites[Index].removeEquipments(Equipments[Choice - 1]);

    }

    public void addEquipmentCs(int Index) throws ConstructionSiteManagerException, ConstructionSiteException {
        Scanner Read = new Scanner(System.in);
        int Choice;
        Equipment[] List = this.ListOfEquipments.getEquipment();
        do {
            System.out.println("========== LISTA DE EQUIPAMENTOS DISPONIVEIS PARA ADICIONAR ==========");
            ListEquipments();
            System.out.println("0 - VOLTAR A MENU ANTERIOR");
            System.out.println("======================================================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > this.ListOfEquipments.getEquipment().length);
        switch (Choice) {
            case 0:
                EquipmentsMenuCs(Index);
                break;
        }

        this.Constructions.ConstructionSites[Index].addEquipments(List[Choice - 1]);
        this.ListOfEquipments.removeEquipment(List[Choice - 1]);
    }

    public void ListEquipments() {
        Equipment[] List = this.ListOfEquipments.getEquipment();
        for (int i = 0; i < List.length; i++) {
            System.out.println(i + 1 + " - " + List[i].getName());
        }
    }

    public void ListEquipmentsCs(int Index) {
        ConstructionSiteClass[] Constructions = this.Constructions.getConstructionSites();
        Equipments ListOfEquipments = Constructions[Index].getEquipments();
        Equipment[] Equipments = ListOfEquipments.getEquipment();
        for (int i = 0; i < Equipments.length; i++) {
            System.out.println(i + 1 + " - " + Equipments[i].getName());
        }
    }

    public void TeamMenu(int Index) throws ConstructionSiteManagerException, ConstructionSiteException {
        Scanner Read = new Scanner(System.in);
        ConstructionSiteClass[] ConstructionSites = this.Constructions.getConstructionSites();
        int Choice;
        do {
            System.out.println("========== MENU DE EQUIPAS ==========");
            System.out.println("1 - MOSTRAR EQUIPAS");
            System.out.println("2 - ADICIONAR EQUIPA Á CONSTRUÇÃO");
            System.out.println("3 - REMOVER EQUIPA DA CONSTRUÇÃO");
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");
            System.out.println("=====================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > 3);
        switch (Choice) {
            case 0:
                EditConstructions();
            case 1:
                Team[] TeamsCs = ConstructionSites[Index].getTeams();
                System.out.println("========== LISTA DE EQUIPAS ALOCADAS NESTA CONSTRUÇÃO ==========");
                for (int i = 0; i < TeamsCs.length; i++) {
                    System.out.println(TeamsCs[i].getName() + " NUMBER OF EMPLOYEES: " + TeamsCs[i].getNumberOfEmployees());
                }
                System.out.println("================================================================");
                EditConstructions();
            case 2:
                TeamClass[] ListOfTeams = this.Teams.getTeams();
                do {
                    System.out.println("========== LISTA DE EQUIPAS NÃO ASSOCIADAS ==========");
                    for (int i = 0; i < ListOfTeams.length; i++) {
                        System.out.println(i + 1 + " - " + ListOfTeams[i]);
                    }
                    Choice = Read.nextInt();
                } while (Choice < 0 || Choice > ListOfTeams.length);
                switch (Choice) {
                    case 0:
                        EditConstructions();
                        break;
                }
                ConstructionSites[Index].addTeam(ListOfTeams[Choice - 1]);
                this.Teams.remove(Choice - 1);
            case 3:
                Team[] TeamsC = ConstructionSites[Index].getTeams();
                do {
                    System.out.println("========== LISTA DE EQUIPAS ALOCADAS NESTA CONSTRUÇÃO ==========");
                    for (int i = 0; i < TeamsC.length; i++) {
                        System.out.println(i + 1 + " - " + TeamsC[i].getName());
                    }
                    System.out.println("0 - VOLTAR AO MENU ANTERIOR");
                    System.out.println("================================================================");
                    Choice = Read.nextInt();
                    break;
                } while (Choice < 0 || Choice > TeamsC.length);

                switch (Choice) {
                    case 0:
                        EditConstructions();
                        break;
                }
                ConstructionSites[Index].removeTeam(TeamsC[Choice - 1]);
                this.Teams.add(TeamsC[Choice - 1]);
                EditConstructions();

        }
    }

    public void ListOfTeamsMenu() {
        int NumberOfConstructions = this.Constructions.getNumberOfConstructionSites();
        ConstructionSiteClass[] ConstructionSites = this.Constructions.getConstructionSites();
        for (int i = 0; i < NumberOfConstructions; i++) {
            System.out.println((i + 1) + " - " + ConstructionSites[i].getName());
        }
    }
}
