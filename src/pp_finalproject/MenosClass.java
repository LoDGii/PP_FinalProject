/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.Employee;
import estgconstroi.Team;
import estgconstroi.exceptions.ConstructionSiteException;
import estgconstroi.exceptions.ConstructionSiteManagerException;
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
    private EquipmentsClass[] ListOfEquipments;
    private EmployeeManagerClass Employees = new EmployeeManagerClass();

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
                    break;
                case 4:
                    TeamsMenu();
                    break;

            }
        } catch (Exception o) {
            System.out.println(o.getMessage());
            PrincipalMenu();

        }

    }

    public void TeamsMenu() throws ConstructionSiteManagerException{
        Scanner Read = new Scanner(System.in);
            int choice;
            do {
                System.out.println("========== MENU DE TEAMS ==========");
                System.out.println("1 - CRIAR NOVA TEAM");
                System.out.println("2 - LISTAR TODAS AS TEAMS");
                System.out.println("3 - LISTAR TEAMS DISPONIVEIS");
                System.out.println("4 - LISTAR TEAMS A TRABALHAR");
                System.out.println("0 - VOLTAR AO MENU PRINCIPAL");
                System.out.println("==========================================");
                choice = Read.nextInt();
            } while (choice < 0 || choice > 4);
            switch (choice) {
                case 0:
                    PrincipalMenu();
                    break;
                case 1:
                    
                    break;
                case 2:
                    System.out.println("========== LISTA DE EQUIPAS ==========");
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
            }
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

    public void EventMenu() {
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
                    EventMenu();
                    break;
                case 1:
                    
                    break;
                case 2:
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 9:
                    
                    break;
                    
            }
            
    }
    
    public void TypeEventMenu() {
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
                    TypeEventMenu();
                    break;
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                    
            }
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
            Scanner Read = new Scanner(System.in);
            int Choice;
            do {
                System.out.println("========== LISTA DE COSNTRUÇÕES ==========");
                ListOfTeamsMenu();
                System.out.println("0 - VOLTAR ATRÁS");
                System.out.println("==========================================");
                System.out.println("OPÇÃO: ");
                Choice = Read.nextInt();
            } while (Choice < 0 || Choice > this.Constructions.NumberOfConstructions);
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
        int Index_cs, Choice;
        do {
            System.out.println("========== LISTA DE CONSTRUÇÕES ==========");
            ListOfTeamsMenu();
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");
            System.out.println("==========================================");
            System.out.println("OPÇÃO: ");
            Index_cs = Read.nextInt();
        } while (Index_cs < 0 || Index_cs > this.Constructions.NumberOfConstructions + 1);
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
                break;
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
                this.Constructions.ConstructionSites[Index_cs].setResponsible(Managers[Choice - 1]);
                System.out.println("RESPONSAVEL DEFINIDO COM SUCESSO!");
                EditConstructions();

            case 4:
                System.out.println("RESPONSAVEL PELA CONSTRUÇÃO: " + this.Constructions.ConstructionSites[Index_cs].getResponsible().getName());
                EditConstructions();
            case 5:
                boolean isValid = this.Constructions.ConstructionSites[Index_cs].isValid();
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
                this.Constructions.ConstructionSites[Index_cs].setPermit(TempPermit, localDate);
            case 7:
                System.out.println("DATA DE TERMINO DE CONSTRUÇÃO: " + this.Constructions.ConstructionSites[Index_cs].getEndDate());
                EditConstructions();
        }

    }

    public void TeamMenu(int Index) throws ConstructionSiteManagerException, ConstructionSiteException {
        Scanner Read = new Scanner(System.in);
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
                Team[] TeamsCs = this.Constructions.ConstructionSites[Index].getTeams();
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
                this.Constructions.ConstructionSites[Index].addTeam(ListOfTeams[Choice - 1]);
                this.Teams.remove(Choice - 1);
            case 3:
                Team[] TeamsC = this.Constructions.ConstructionSites[Index].getTeams();
                do{
                System.out.println("========== LISTA DE EQUIPAS ALOCADAS NESTA CONSTRUÇÃO ==========");
                for (int i = 0; i < TeamsC.length; i++) {
                    System.out.println(i + 1 + " - " + TeamsC[i].getName());
                }
                System.out.println("0 - VOLTAR AO MENU ANTERIOR");
                System.out.println("================================================================");
                Choice = Read.nextInt();
                break;
                }while(Choice < 0 || Choice > TeamsC.length);
                
                switch(Choice){
                    case 0:
                        EditConstructions();
                        break;
                }
                this.Constructions.ConstructionSites[Index].removeTeam(TeamsC[Choice - 1]);
                this.Teams.add(TeamsC[Choice - 1]);
                EditConstructions();
               
           
        }
    }

    public void ListOfTeamsMenu() {
        for (int i = 0; i < this.Constructions.NumberOfConstructions; i++) {
            System.out.println((i + 1) + " - " + this.Constructions.ConstructionSites[i].getName());
        }
    }
}
