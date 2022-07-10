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

import estgconstroi.enums.EmployeeType;
import estgconstroi.exceptions.TeamException;
import java.util.Scanner;

/**
 * Class with all the arguments for the Team's menu.
 *
 */
public class TeamMenu {

    /**
     * Principal Team's Menu, the user can <b>create, edit and see</b> the teams
     *
     * @param teams variable with all the information of the teams in the
     * company.
     */
    public void principalMenu(TeamManagerClass teams) {
        Scanner Read = new Scanner(System.in);
        int Choice = -1;
        do {
            System.out.println("========== MENU DE EQUIPAS ==========");
            System.out.println("1 - CRIAR NOVA EQUIPA");//DONE
            System.out.println("2 - LISTAR EQUIPAS INATIVAS");//DONE
            System.out.println("3 - LISTAR EQUIPAS EM ATIVIDADE");//DONE
            System.out.println("4 - EDITAR EQUIPA");
            System.out.println("0 - VOLTAR AO MENU PRINCIPAL");
            System.out.println("=====================================");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > 4);
        switch (Choice) {
            case 0:
                break;
            case 1:
                createTeamMenu(teams);
                break;
            case 2:
                showByStatusTeams(teams, TeamStatus.INACTIVE);
                break;
            case 3:
                showByStatusTeams(teams, TeamStatus.WORKING);
                break;
            case 4:
                break;
        }
    }

    /**
     * This Menu will show all the teams with the status given by the argument,
     * It will also wait until the user writes the number "0" in the console to
     * continue to run.
     *
     * @param teams variable with all the information of the teams in the
     * company.
     * @param status variable with the status the user is looking for.
     */
    public void showByStatusTeams(TeamManagerClass teams, TeamStatus status) {
        Scanner Read = new Scanner(System.in);
        int Choice = 0;
        do {
            System.out.println("========== LISTA DE EQUIPAS " + status + "==========");
            teams.showTeamsByStatus(TeamStatus.INACTIVE);
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");
            System.out.println("===============================================");
            Choice = Read.nextInt();
        } while (Choice != 0);
        principalMenu(teams);
    }

    /**
     * In this Menu the user will create a new Team.
     *
     * @param teams variable with all the information of the teams in the
     * company.
     */
    public void createTeamMenu(TeamManagerClass teams) {
        String TempName;
        Scanner Read = new Scanner(System.in);
        System.out.println("NOME: ");
        TempName = Read.next();
        TeamClass team = new TeamClass(TempName);
        teams.add(team);

    }

    /**
     * Menu where you can edit a team
     *
     * @param teams variable with all the information of the teams in the
     * company.
     */
    public void editTeam(TeamManagerClass teams, EmployeeManagerClass emp) throws TeamException {
        int teamIndex = selectTeamToEdit(teams);
        Scanner Read = new Scanner(System.in);
        int Choice = 0;
        do {
            System.out.println("========== EDITAR EQUIPA ==========");
            System.out.println("1 - DEFINIR LIDER");//DONE
            System.out.println("2 - ADICIONAR EQUIPAMENTO");
            System.out.println("3 - ALTERAR NOME");//DONE
            System.out.println("4 - ADICIONAR FUNCIONÁRIO");//DONE
            System.out.println("5 - REMOVER FUNCIONÁRIO");//DONE
            System.out.println("6 - REMOVER EQUIPAMENTO");
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");//DONE
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > 6);
        switch (Choice) {
            case 0:
                principalMenu(teams);
                break;
            case 1:
                setLeaderMenu(teams, emp, teamIndex);
                break;
            case 2:
                break;
            case 3:
                setNameMenu(teams, teamIndex);
                break;
            case 4:
                addEmployeeMenu(teams, emp, teamIndex);
                break;
            case 5:
                removeEmployeeMenu(teams, emp, teamIndex);
                break;
            case 6:
                break;
        }
    }

    /**
     * Remove Employee from a Team.
     * <p>
     * First the User will choose the team to be removed.
     * <p>
     * After that we will get the employee Index and set the employee status to
     * <b>FREE</b> and remove the employee from the team using the method
     * <b>removeEmployee()</b>
     *
     * @param teams variable with all the information of the teams in the
     * company.
     * @param emp variable with all the information of the employees in the
     * company.
     * @param teamIndex index of the team we're editing.
     * @throws TeamException
     */
    public void removeEmployeeMenu(TeamManagerClass teams, EmployeeManagerClass emp, int teamIndex) throws TeamException {
        TeamClass[] team = teams.getTeams();
        EmployeeClass[] empl = (EmployeeClass[]) team[teamIndex].getEmployees();
        Scanner Read = new Scanner(System.in);
        int Choice;
        do {
            System.out.println("========== LISTA DE EMPREGADOS ==========");
            for (int i = 0; i < empl.length; i++) {
                System.out.println(i + 1 + " - " + empl[i].getName());
            }
            System.out.println("=========================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > empl.length);
        switch (Choice) {
            case 0:
                editTeam(teams, emp);
                break;
            default:
                teams.removeEmployee(teamIndex, empl[Choice - 1]);
                int empIndex = emp.getEmployee(empl[Choice - 1]);
                emp.setEmployeeStatus(empIndex, EmployeeStatus.FREE);
        }
    }

    /**
     *
     * Add an Employee to a Team
     * <p>
     * First we make a menu with all the Employees with EmployeeStatus of
     * <b>FREE</b>
     * <p>
     * After the user chose the employee he wants to add to the team we add the
     * employee to the array of employees in the team object with the method
     * <b>addEmployee()</b> and after that we get the index of the employee with
     * the method <b>getEmployeeStatus()</b> and set the EmployeeStatus to
     * <b>WORKING</b>
     *
     *
     * @param teams variable with all the information of the teams in the
     * company.
     * @param emp variable with all the information of the employees in the
     * company.
     * @param teamIndex index of the team we're editing.
     * @throws TeamException
     */
    public void addEmployeeMenu(TeamManagerClass teams, EmployeeManagerClass emp, int teamIndex) throws TeamException {
        EmployeeClass[] empl = emp.getEmployees();
        EmployeeClass[] free = new EmployeeClass[empl.length];
        Scanner Read = new Scanner(System.in);
        int Choice;
        int k = 0;
        do {
            System.out.println("========== LISTA DE FUNCIONÁRIOS ==========");
            for (int i = 0; i < empl.length; i++) {
                if (empl[i].getStatus() == EmployeeStatus.FREE) {
                    System.out.println(k + 1 + " - " + empl[i].getName());
                    free[k] = empl[i];
                    k++;
                }
            }
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");
            System.out.println("=================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > empl.length);
        EmployeeClass[] freefin = new EmployeeClass[k];
        System.arraycopy(free, 0, freefin, 0, k);
        switch (Choice) {
            case 0:
                editTeam(teams, emp);
                break;
            default:
                teams.addEmployee(empl[Choice - 1], teamIndex);
                int emplIndex = emp.getEmployee(empl[Choice - 1]);
                emp.setEmployeeStatus(emplIndex, EmployeeStatus.WORKING);
                editTeam(teams, emp);
                break;

        }
    }

    /**
     * Set's the name of the team
     *
     * @param teams variable with all the information of the teams in the
     * company.
     * @param TeamIndex index of the team to be edited
     */
    public void setNameMenu(TeamManagerClass teams, int TeamIndex) {
        Scanner Read = new Scanner(System.in);
        System.out.println("NOVO NOME: ");
        String TempName = Read.next();
        teams.setName(TeamIndex, TempName);
        principalMenu(teams);
    }

    /**
     * Set's the Leader of a team.
     * <p>
     * It first give's the user the option to select wich leader he wants to
     * assign, we know if an Employee is a Leader by using the
     * <b>getEmployeeByTypee()</b> that returns the Employees without an
     * assigned team and with the type given by the user (TEAM_LEADER in this
     * case).
     * <p>
     * After doing the menu and the user chose the team we use the
     * <b>getEmployee()</b> method that give us the index of the choosen
     * employee by using the UUID.
     * <p>
     * In the last step we change the employee status to <b>WORKING</b> using
     * the <b>setEmployeeStatus()</b> method and It Finally set's the leader
     * with the method <b>setLeader()</b>.
     *
     * @param Teams variable with all the information of the teams in the
     * company.
     * @param Employees variable with all the information of the employees in
     * the company
     * @param teamIndex index of the team we're editing.
     * @throws TeamException
     */
    public void setLeaderMenu(TeamManagerClass Teams, EmployeeManagerClass Employees, int teamIndex) throws TeamException {

        Scanner Read = new Scanner(System.in);
        EmployeeClass[] emp = Employees.getEmployeeByType(EmployeeType.TEAM_LEADER);
        int Choice;
        do {
            System.out.println("========== LISTA DE LIDERES ==========");
            for (int i = 0; i < emp.length; i++) {
                System.out.println(i + 1 + " - " + emp[i].getName());
            }
            System.out.println("0 - VOLTAR ATRAS");
            System.out.println("======================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > teamIndex);
        switch (Choice) {
            case 0:
                principalMenu(Teams);
                break;
            default:
                int Index = Employees.getEmployee(emp[Choice - 1]);
                EmployeeClass employ = Employees.getEmployee(Index);
                Employees.setEmployeeStatus(Index, EmployeeStatus.WORKING);
                Teams.setLeader(employ, Index);
                editTeam(Teams, Employees);
        }
    }

    /**
     * Ask's the user to select the team he want's to edit.
     *
     * @param teams variable with all the information of the teams in the
     * company.
     * @return Index of the team selected
     */
    public int selectTeamToEdit(TeamManagerClass teams) {
        Scanner Read = new Scanner(System.in);
        int Choice = 0;
        int Index_Team = 0;
        int NumberOfTeams = teams.NumberOfTeams;
        do {
            System.out.println("========== LISTA DE EQUIPAS ==========");
            teams.showAllTeams();
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > NumberOfTeams);
        if (Choice == 0) {
            principalMenu(teams);
            return 0;
        } else {
            Index_Team = Choice;
            Index_Team--;
            return Index_Team;
        }
    }

}
