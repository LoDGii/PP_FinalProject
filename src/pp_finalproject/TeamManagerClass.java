/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

/**
 *
 * @author Utilizador
 */
public class TeamManagerClass {

    private TeamClass[] Teams;
    protected int NumberOfTeams = 0;

    public void add(TeamClass team) {
        TeamClass[] FakeArray = new TeamClass[this.NumberOfTeams + 1];
        for (int i = 0; i < this.NumberOfTeams; i++) {
            FakeArray[i] = this.Teams[i];
        }
        FakeArray[this.NumberOfTeams] = team;
        this.NumberOfTeams++;
        this.Teams = FakeArray;
    }
    
    public TeamClass[] getTeams(){
        return this.Teams;
    }
}
