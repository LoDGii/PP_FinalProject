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

import estgconstroi.Employee;
import estgconstroi.Equipment;
import estgconstroi.Equipments;
import estgconstroi.Team;
import estgconstroi.exceptions.ConstructionSiteException;
import estgconstroi.exceptions.TeamException;

/**
 *
 * Class with all the arguments for the Team's menu.
 */
public class TeamManagerClass {

    private TeamClass[] Teams;
    protected int NumberOfTeams = 0;

    /**
     * Create's a new team
     *
     * @param team new team to be created.
     */
    public void add(TeamClass team) {
        if (NumberOfTeams != 0) {

            TeamClass[] FakeArray = new TeamClass[this.NumberOfTeams + 1];
            for (int i = 0; i < this.NumberOfTeams; i++) {
                FakeArray[i] = this.Teams[i];
            }
            FakeArray[this.NumberOfTeams] = (TeamClass) team;

            this.NumberOfTeams++;
            this.Teams = FakeArray;
        } else {
            this.Teams = new TeamClass[1];
            this.Teams[0] = team;
            this.NumberOfTeams++;

        }

    }

    /**
     * Add's an employee to a team
     *
     * @param emp employee to be added to the team
     * @param Index Index of the team being edited.
     * @throws TeamException
     */
    public void addEmployee(EmployeeClass emp, int Index) throws TeamException {
        this.Teams[Index].addEmployees(emp);
    }

    /**
     * Set's the name of a team.
     *
     * @param Index_Team Index of the team being edited.
     * @param TempName New name of the team.
     */
    public void setName(int Index_Team, String TempName) {
        this.Teams[Index_Team].setName(TempName);
    }

    /**
     * Removes an employee from a team
     *
     * @param Index_Team Index of the team being edited
     * @param emp employee to be removed
     * @throws TeamException
     */
    public void removeEmployee(int Index_Team, Employee emp) throws TeamException {
        this.Teams[Index_Team].removeEmployee(emp);
    }

    /**
     * Associates an equipment to a team
     *
     * @param Index index of the team to receive the equipment
     * @param eqpmnt equipment to be associated.
     * @throws ConstructionSiteException
     */
    public void setEquipments(int Index, Equipment eqpmnt) throws ConstructionSiteException {
        this.Teams[Index].addEquipments(eqpmnt);
    }

    /**
     * Return's the equipments associated with any team
     *
     * @return equipments associated with a team
     */
    public Equipments[] getEquipments() {
        Equipments[] FakeArray = new Equipments[this.NumberOfTeams];
        for (int i = 0; i < FakeArray.length; i++) {
            FakeArray[i] = this.Teams[i].getEquipments();
        }
        return FakeArray;
    }

    /**
     * Returns the status of a team.
     *
     * @param Index Index of the team to be checkeds
     * @return team status.
     */
    public TeamStatus getStatus(int Index) {
        return this.Teams[Index].getStatus();
    }

    /**
     * Remove's a team
     *
     * @param Remove_Index Index of the team to be removed.
     */
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

    /**
     * Set's the leader of a team.
     *
     * @param emp array with all the employees of the company.
     * @param Index Index of the team being edited.
     * @throws TeamException
     */
    public void setLeader(Employee emp, int Index) throws TeamException {
        this.Teams[Index].setLeader(emp);
    }

    /**
     * Return's all the teams in the company
     *
     * @return all the teams in the company
     */
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
