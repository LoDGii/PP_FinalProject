/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.Employee;
import estgconstroi.Equipment;
import estgconstroi.Equipments;
import estgconstroi.Team;
import estgconstroi.exceptions.ConstructionSiteException;
import estgconstroi.exceptions.TeamException;

/**
 *
 * @author Utilizador
 */
public class TeamManagerClass {

    private TeamClass[] Teams;
    protected int NumberOfTeams = 0;

    public void add(Team team) {
        TeamClass[] FakeArray = new TeamClass[this.NumberOfTeams + 1];
        for (int i = 0; i < this.NumberOfTeams; i++) {
            FakeArray[i] = this.Teams[i];
        }
        FakeArray[this.NumberOfTeams] = (TeamClass) team;

        this.NumberOfTeams++;
        this.Teams = FakeArray;

    }

    public void addEmployee(EmployeeClass emp, int Index) throws TeamException {
        this.Teams[Index].addEmployees(emp);
    }

    public void setName(int Index_Team, String TempName) {
        this.Teams[Index_Team].setName(TempName);
    }

    public void removeEmployee(int Index_Team, Employee emp) throws TeamException {
        this.Teams[Index_Team].removeEmployee(emp);
    }

    public void setEquipments(int Index, Equipment eqpmnt) throws ConstructionSiteException {
        this.Teams[Index].addEquipments(eqpmnt);
    }

    public Equipments[] getEquipments() {
        Equipments[] FakeArray = new Equipments[this.NumberOfTeams];
        for (int i = 0; i < FakeArray.length; i++) {
            FakeArray[i] = this.Teams[i].getEquipments();
        }
        return FakeArray;
    }

    public TeamStatus getStatus(int Index) {
        return this.Teams[Index].getStatus();
    }

    public void remove(int Remove_Index) {
        TeamClass[] FakeArray = new TeamClass[this.NumberOfTeams - 1];
        int k = 0;
        for (int i = 0; i < this.NumberOfTeams; i++) {
            if (i != Remove_Index) {
                FakeArray[k] = this.Teams[i];
                k++;
            }
        }
    }

    public void setLeader(Employee emp, int Index) throws TeamException {
        this.Teams[Index].setLeader(emp);
    }

    public TeamClass[] getTeams() {
        return this.Teams;
    }

    /**
     * Show's all teams in a String form
     */
    public void showAllTeams() {
        for (int i = 0; i < this.Teams.length; i++) {
            System.out.println(i + 1 + " - " + this.Teams[i].getName());

        }

    }

    /**
     * Set's the team status
     *
     * @param Index Index of the team the user wants to edit
     * @param stat status the team will be given
     */
    public void setTeamStatus(int Index, TeamStatus stat) {
        this.Teams[Index].setStatus(stat);
    }

    /**
     * Returns in String form all the Teams with a given status
     *
     * @param status status to be searched
     */
    public void showTeamsByStatus(TeamStatus status) {
        TeamClass[] teams = this.Teams;
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].getStatus() == status) {
                System.out.println(teams[i].getName() + " - " + teams[i].getLeader());
            }
        }
    }



}
