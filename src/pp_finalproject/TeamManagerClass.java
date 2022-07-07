/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.Team;

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
    
    public void remove(int Remove_Index){
        TeamClass[] FakeArray = new TeamClass[this.NumberOfTeams - 1];
        int k = 0;
        for(int i = 0;i < this.NumberOfTeams;i++){
            if(i != Remove_Index){
                FakeArray[k] = this.Teams[i];
                k++;
            }
        }
    }
    
    public TeamClass[] getTeams(){
        return this.Teams;
    }
}
