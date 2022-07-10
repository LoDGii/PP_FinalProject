/**
 * Nome: Diogo Gomes Cardoso
 * Número: 8210193
 * Turma: LEI1T1
 *
 *
 * Nome: Bruno Miguel Rodrigues Novais
 *  Número: 8210333
 *  Turma: LEI1T1
 */
package pp_finalproject;

import estgconstroi.ConstructionSiteManager;
import estgconstroi.Employee;
import estgconstroi.Team;
import estgconstroi.enums.EmployeeType;
import estgconstroi.exceptions.ConstructionSiteException;
import estgconstroi.exceptions.ConstructionSiteManagerException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * Class with all the arguments for the Construction Sites menu.
 */
public class ConstructionSiteMenu {

    /**
     * Principal Construction Sites Menu. The user can <b>create, edit and
     * see</b> the Construction Sites
     *
     * @param cs variable with all the information of the Construction Sites in
     * the company.
     * @throws ConstructionSiteManagerException
     */
    public void principalMenu(ConstructionSiteManagerClass cs, EmployeeManagerClass empl, TeamManagerClass team, EquipmentsClass equip) throws ConstructionSiteManagerException, ConstructionSiteException {
        Scanner Read = new Scanner(System.in);
        int Choice;
        do {
            System.out.println("========== MENU DE CONSTRUÇÕES ==========");
            System.out.println("1 - CRIAR NOVO LOCAL DE CONSRUÇÃO");//DONE
            System.out.println("2 - INFORMAÇÃO SOBRE TODAS AS CONSTRUÇÕES");//DONE
            System.out.println("3 - REMOVER CONSTRUÇÃO");//DONE
            System.out.println("4 - EDITAR UMA CONSTRUÇÃO");
            System.out.println("0 - VOLTAR AO MENU PRINCIPAL");
            System.out.println("==========================================");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > 4);
        switch (Choice) {
            case 0:
                break;
            case 1:
                createNewConstructionSite(cs);
                principalMenu(cs, empl, team, equip);
                break;
            case 2:
                showConstructionSiteInformation(cs);
                principalMenu(cs, empl, team, equip);
                break;
            case 3:
                removeConstructionSite(cs, empl, team, equip);
                principalMenu(cs, empl, team, equip);
                break;
            case 4:
                editConstructionSite(cs, empl);
                break;
        }
    }

    /**
     *
     * Create's a new Construction Site.
     * <p>
     * First It asks the user for the information from the construction site and
     * after that, using the constructor method, creates a new construction site
     * and adds it to the array with all the others construction sites.
     *
     *
     * @param cs
     * @throws ConstructionSiteManagerException
     */
    public void createNewConstructionSite(ConstructionSiteManagerClass cs) throws ConstructionSiteManagerException {
        String TempName, TempLocation, TempPermit, TempDate;
        Scanner Read = new Scanner(System.in);
        System.out.println("NOME: ");
        TempName = Read.next();
        System.out.println("LOCALIZAÇÃO: ");
        TempLocation = Read.next();
        System.out.print("PERMIT: ");
        TempPermit = Read.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        System.out.println("DATA DE EXPIRAÇÃO (dd/mm/yyyy): ");
        TempDate = Read.next();
        LocalDate localDate = LocalDate.parse(TempDate, formatter);
        ConstructionSiteClass construction = new ConstructionSiteClass(TempName, TempLocation, localDate, TempPermit);
        cs.add(construction);

    }

    /**
     *
     * Show's information about all the construction sites.
     * <p>
     * This method uses another method from the ConstructionSiteManagerClass to
     * show all the information from the Construction Sites.
     *
     *
     * @param cs variable with all the information of the Construction Sites in
     * the company.
     */
    public void showConstructionSiteInformation(ConstructionSiteManagerClass cs) {
        Scanner Read = new Scanner(System.in);
        int Choice = 2;
        do {
            cs.showAllConstructionSites();
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");
            System.out.println("===================================================");
            Choice = Read.nextInt();
        } while (Choice != 0);

    }

    /**
     * Removes a Construction Site
     *
     * @param cs variable with all the information of the Construction Sites in
     * the company.
     * @throws ConstructionSiteManagerException
     */
    public void removeConstructionSite(ConstructionSiteManagerClass cs, EmployeeManagerClass empl, TeamManagerClass team, EquipmentsClass equip) throws ConstructionSiteManagerException {
        int indexConstructionSite = selectConstructionSite(cs);
        cs.remove(indexConstructionSite, empl, team, equip);

    }

    public void editConstructionSite(ConstructionSiteManagerClass cs, EmployeeManagerClass emp) throws ConstructionSiteManagerException, ConstructionSiteException {
        Scanner Read = new Scanner(System.in);
        int Choice = 0;
        int constructionSiteIndex;
        constructionSiteIndex = selectConstructionSite(cs);
        if (constructionSiteIndex == -1) {

        } else {
            do {
                System.out.println("========== MENU EDIÇÃO DE CONSTRUCÕES ==========");
                System.out.println("1 - EQUIPAS");
                System.out.println("2 - EQUIPAMENTOS");
                System.out.println("3 - DEFINIR RESPONSAVEL");//DONE
                System.out.println("4 - VERIFICAR RESPONSAVEL PELA CONSTRUÇÃO");//DONE
                System.out.println("5 - ALTERAR PERMIT");//DONE
                System.out.println("0 - VOLTAR AO MENU ANTERIOR");//DONE
                System.out.println("================================================");
            } while (Choice < 0 || Choice > 5);
            switch (Choice) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    setConstructionResponsible(cs, emp, constructionSiteIndex);
                    editConstructionSite(cs, emp);
                    break;
                case 4:
                    showConstructionResponsible(cs, constructionSiteIndex);
                    editConstructionSite(cs, emp);
                    break;
                case 5:
                    changePermit(cs, constructionSiteIndex);
                    editConstructionSite(cs, emp);
                    break;
                case 6:
                    break;
            }
        }
    }

    /**
     * Creates a new permit for the construction site
     *
     * @param cs variable with all the information of the Construction Sites in
     * the company.
     * @param csIndex index of the construction site to be edited
     */
    public void changePermit(ConstructionSiteManagerClass cs, int csIndex) {
        String TempDate, TempPermit;
        Scanner Read = new Scanner(System.in);
        System.out.println("PERMIT: ");
        TempPermit = Read.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("DATA DE EXPIRAÇÃO (dd/mm/yyyy): ");
        TempDate = Read.next();
        LocalDate localDate = LocalDate.parse(TempDate, formatter);
        cs.setPermit(csIndex, localDate, TempPermit);

    }

    /**
     *
     * Menu to select the ConstructionSite to edit.
     *
     * @param cs variable with all the information of the Construction Sites in
     * the company.
     * @return index of the construction site the user wants to edit.
     * @throws ConstructionSiteManagerException
     */
    public int selectConstructionSite(ConstructionSiteManagerClass cs) throws ConstructionSiteManagerException {
        Scanner Read = new Scanner(System.in);
        String TempDate;
        int NumberOfConstructions = cs.getNumberOfConstructionSites();
        ConstructionSiteClass[] ConstructionSites = cs.getConstructionSites();
        int Index_cs, Choice;
        do {
            System.out.println("========== LISTA DE CONSTRUÇÕES ==========");
            cs.ListOfTeamsMenu();
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");
            System.out.println("==========================================");
            System.out.println("OPÇÃO: ");
            Index_cs = Read.nextInt();
        } while (Index_cs < 0 || Index_cs > NumberOfConstructions + 1);
        switch (Index_cs) {
            case 0:

                return -1;
            default:
                Index_cs--;
                return Index_cs;
        }

    }

    /**
     * Set's construction site responsible.
     * <p>
     * It first gets the list of free employees with the <b>FREE</b> status and
     * the <b>MANAGER</b> type and after the user chooses wich one he wants to
     * assign the status of the employee is changed to
     * <b>WORKING</b> and is set as responsible for the construction.
     *
     *
     * @param cs variable with all the information of the Construction Sites in
     * the company.
     * @param empl variable with all the information of the Employeess in the
     * company.
     * @param csIndex Index of the construction site to be edited
     * @throws ConstructionSiteException
     */
    public void setConstructionResponsible(ConstructionSiteManagerClass cs, EmployeeManagerClass empl, int csIndex) throws ConstructionSiteException {
        Scanner Read = new Scanner(System.in);
        int Choice = 0;
        EmployeeClass[] employees = empl.getEmployeeByTypeAndStatus(EmployeeType.MANAGER, EmployeeStatus.FREE);
        do {
            System.out.println("========== LISTA DE GESTORES ===========");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(i + 1 + " - " + employees[i].getName() + " - " + employees[i].getUUID());
            }
            System.out.println("========================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > employees.length);
        switch (Choice) {
            case 0:
                break;
            default:
                cs.setResponsible(csIndex, employees[Choice - 1]);
                int choosenIndex = empl.getEmployee(employees[Choice - 1]);
                empl.setEmployeeStatus(choosenIndex, EmployeeStatus.WORKING);
        }
    }

    /**
     * Show's the resposible for the Construction Site
     *
     *
     *
     * @param cs variable with all the information of the Construction Sites in
     * the company
     * @param csIndex Index of the Construction Site the user wants to see
     */
    public void showConstructionResponsible(ConstructionSiteManagerClass cs, int csIndex) {
        Employee emplo = cs.getResponsible(csIndex);
        Scanner Read = new Scanner(System.in);
        int Choice = 0;
        do {
            System.out.println("========== RESPONSAVEL ==========");
            System.out.println(emplo.getName() + " - " + emplo.getUUID());
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");
            Choice = Read.nextInt();
        } while (Choice != 0);

    }

    public void teamMenu(ConstructionSiteManagerClass cs, EmployeeManagerClass empl, TeamManagerClass team, EquipmentsClass equip, int Index) throws ConstructionSiteManagerException, ConstructionSiteException {
        Scanner Read = new Scanner(System.in);
        ConstructionSiteClass[] ConstructionSites = cs.getConstructionSites();
        int Choice;
        do {
            System.out.println("========== MENU DE EQUIPAS ==========");
            System.out.println("1 - MOSTRAR EQUIPAS");//DONE
            System.out.println("2 - ADICIONAR EQUIPA Á CONSTRUÇÃO");//DONE
            System.out.println("3 - REMOVER EQUIPA DA CONSTRUÇÃO");
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");//DONE
            System.out.println("=====================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > 3);
        switch (Choice) {
            case 0:
                principalMenu(cs, empl, team, equip);
                break;
            case 1:
                cs.ListOfTeamsMenu(Index);
                break;
            case 2:
                addTeam(cs, empl, team, equip, Index);
                teamMenu(cs, empl, team, equip, Index);
                break;
            case 3:
                break;

        }
    }

    

    public void addTeam(ConstructionSiteManagerClass cs, EmployeeManagerClass empl, TeamManagerClass team, EquipmentsClass equip, int Index) throws ConstructionSiteException {
        TeamClass[] ListOfTeams = team.getTeams();
        Scanner Read = new Scanner(System.in);
        int Choice = 0;
        int Indexfinal = 0;
        TeamClass[] free = new TeamClass[ListOfTeams.length];
        int k = 0;
        for (int i = 0; i < ListOfTeams.length; i++) {
            if (ListOfTeams[i].getStatus() == TeamStatus.FREE) {
                free[k] = ListOfTeams[i];
                k++;
            }
        }
        do {
            System.out.println("========== LISTA DE EQUIPAS NÃO ASSOCIADAS ==========");
            for (int i = 0; i < free.length; i++) {
                System.out.println(i + 1 + " - " + free[i]);
            }
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > free.length);
        switch (Choice) {
            case 0:
                break;
            default:
                Employee[] emplo = free[Choice - 1].getEmployees();
                for (int i = 0; i < emplo.length; i++) {
                    int em = empl.getEmployee(emplo[i]);
                    empl.setEmployeeStatus(em, EmployeeStatus.WORKING);
                }
                cs.ConstructionSites[Index].addTeam(free[Choice - 1]);
                for (int i = 0; i < ListOfTeams.length; i++) {
                    if (free[Choice - 1].getName().contentEquals(ListOfTeams[i].getName())) {
                        Indexfinal = i;
                    }
                }
                team.remove(Indexfinal);
        }

    }

}
