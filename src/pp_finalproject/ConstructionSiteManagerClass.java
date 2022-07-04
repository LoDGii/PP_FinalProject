/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.ConstructionSite;
import estgconstroi.ConstructionSiteManager;
import estgconstroi.Equipment;
import estgconstroi.Team;
import estgconstroi.exceptions.ConstructionSiteManagerException;
import java.time.LocalDate;
import java.util.Arrays;

/**
 *
 * @author Utilizador
 */
public class ConstructionSiteManagerClass implements ConstructionSiteManager {
    private int NumberOfConstructions;
    private ConstructionSiteClass[] ConstructionSites;
    @Override
    public void add(ConstructionSite cs) throws ConstructionSiteManagerException {
        ConstructionSiteClass[] FakeArray = new ConstructionSiteClass[this.NumberOfConstructions + 1];
        for(int i = 0; i < this.NumberOfConstructions;i++){
            FakeArray[i] = this.ConstructionSites[i];
        }
        FakeArray[this.NumberOfConstructions] = (ConstructionSiteClass) cs;
        this.ConstructionSites = FakeArray;
        this.NumberOfConstructions++;
    }

    @Override
    public Team[] getWorkingTeams() {
        int NumberOfTeams = 0;
        Team[] FakeArray = new Team[0];
        Team[] FakeArrayTwo;
        Team[] FakeArrayThree;
        for(int i = 0; i < this.NumberOfConstructions;i++){
           FakeArrayTwo = new Team[this.ConstructionSites[i].getTeams().length];
           FakeArrayTwo = this.ConstructionSites[i].getTeams();
           FakeArrayThree = new Team[NumberOfTeams + this.ConstructionSites[i].getTeams().length];
           System.arraycopy(FakeArrayThree, 0, FakeArrayTwo, 0, this.ConstructionSites[i].getTeams().length );
           if(i > 0){
           System.arraycopy(FakeArrayThree, 0, FakeArray,this.ConstructionSites[i].getTeams().length , NumberOfTeams );
           }
           FakeArray = FakeArrayThree;
           NumberOfTeams += this.ConstructionSites[i].getTeams().length;
        }
        return FakeArray;
    }

    @Override
    public Team[] getIddleTeams() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Equipment[] getEquipmentsInUse() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Equipment[] getIddleEquipments() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ConstructionSite[] getConstructionSitesWithPermitExpired() {
        LocalDate today = LocalDate.now();
        int NumberOfExpired = 0;
        ConstructionSite[] FakeArray = new ConstructionSite[this.NumberOfConstructions];
        for(int i = 0; i < this.NumberOfConstructions;i++){
            if(this.ConstructionSites[i].getPermitExpirationDate().isBefore(today) == true){
                FakeArray[NumberOfExpired] = this.ConstructionSites[i];
                NumberOfExpired++;
            }
        }
        ConstructionSite[] FakeArrayTwo = new ConstructionSite[NumberOfExpired];
        for(int i = 0;i < NumberOfExpired;i++){
            FakeArrayTwo[i] = FakeArray[i];
        }
        return FakeArrayTwo;
    }

    @Override
    public boolean isValid() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
