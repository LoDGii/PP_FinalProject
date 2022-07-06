/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.ConstructionSite;
import estgconstroi.Employee;
import estgconstroi.Equipments;
import estgconstroi.Team;
import estgconstroi.enums.EmployeeType;
import estgconstroi.exceptions.ConstructionSiteException;
import java.time.LocalDate;

/**
 *
 * @author Utilizador
 */
public class ConstructionSiteClass implements ConstructionSite {

    private String Name;
    private String Location;
    private String Permit;
    private LocalDate Expiration_Date;
    private LocalDate Start_Date;
    private EmployeeClass Responsible;
    private TeamClass[] Teams;
    private EquipmentClass[] Equipment;
    private int NumberOfTeams;
    private int NumberOfEquipments;

    public ConstructionSiteClass(String TempName, String TempLocation, LocalDate TempExpirationDate, String TempPermit) {
        this.Name = TempName;
        this.Location = TempLocation;
        this.Expiration_Date = TempExpirationDate;
        this.NumberOfEquipments = 0;
        this.NumberOfTeams = 0;
        this.Permit = TempPermit;
    }

    @Override
    public String getName() {
        return this.Name;
    }

    @Override
    public String getLocation() {
        return this.Location;
    }

    @Override
    public String getPermit() {
        return this.Permit;
    }

    @Override
    public LocalDate getPermitExpirationDate() {
        return this.Expiration_Date;
    }

    @Override
    public LocalDate getStartDate() {
        return this.Start_Date;
    }

    @Override
    public LocalDate getEndDate() {
        return this.Expiration_Date;
    }

    @Override
    public void setPermit(String string, LocalDate ld) {
        this.Permit = string;
    }

    @Override
    public Employee getResponsible() {
        EmployeeClass responsable = new EmployeeClass();
        responsable = this.Responsible;
        return responsable;
    }

    @Override
    public void setResponsible(Employee empl) throws ConstructionSiteException {
        try {
            this.Responsible = (EmployeeClass) empl;

        } catch (Exception exc) {
            throw new ConstructionSiteException("NÃO FOI POSSIVEL NOMEAR ESTE RESPONSÁVEL!");
        }

    }

    @Override
    public void addTeam(Team team) throws ConstructionSiteException {
        try {

            boolean Equal_Exist = false;
            for (int i = 0; i < this.NumberOfTeams; i++) {
                if (team.getName().equals(this.Teams[i].getName())) {
                    Equal_Exist = true;
                }
            }
            if (Equal_Exist == false) {
                TeamClass[] FakeArray = new TeamClass[this.NumberOfTeams + 1];
                for (int i = 0; i < this.NumberOfTeams; i++) {
                    FakeArray[i] = this.Teams[i];
                }
                FakeArray[this.NumberOfTeams] = (TeamClass) team;
                this.Teams = FakeArray;
                this.NumberOfTeams++;
            } else {
                System.out.println("EQUIPA JÁ PERTENCE A ESTA CONSTRUÇÃO!");
            }
        } catch (Exception e) {
            throw new ConstructionSiteException("ERRO AO ADICIONAR A EQUIPA!");
        }
    }

    @Override
    public void removeTeam(Team team) throws ConstructionSiteException {
        try {
            int index_remove = 0;
            boolean Equal_Exist = false;
            int k = 0;
            for (int i = 0; i < this.NumberOfTeams; i++) {
                if (team.getName().equals(this.Teams[i].getName())) {
                    index_remove = i;
                    Equal_Exist = true;
                }
            }
            if (Equal_Exist == true) {
                TeamClass[] FakeArray = new TeamClass[this.Teams.length - 1];
                for (int i = 0; i < this.NumberOfTeams; i++) {
                    if (i != index_remove) {
                        FakeArray[k] = this.Teams[i];
                        k++;
                    }
                }
                this.Teams = FakeArray;
                this.NumberOfTeams--;
            } else {
                System.out.println("NÃO FOI POSSIVEL COMPLETAR ESTA OPERAÇÃO!");
            }
        } catch (Exception e) {
            throw new ConstructionSiteException("ERRO DURANTE A REMOÇÃO!");
        }

    }

    @Override
    public Team[] getTeams(String string) {
        int[] IndexOfNumbers = new int[this.NumberOfTeams];
        int k = 0;
        for (int i = 0; i < this.NumberOfTeams; i++) {
            if (this.Teams[i].getName().toLowerCase().equals(string.toLowerCase())) {
                IndexOfNumbers[k] = i;
                k++;
            }
        }
        Team[] EqualTeams = new Team[k];
        for (int i = 0; i < k + 1; i++) {
            EqualTeams[i] = this.Teams[IndexOfNumbers[i]];
        }
        return EqualTeams;
    }

    @Override
    public Team[] getTeams() {
        return this.Teams;
    }

    @Override
    public boolean isValid() {
        boolean HasTeams = false;
        boolean DateIsValid = false;
        boolean HasManager = false;
        LocalDate today = LocalDate.now();
        if (this.NumberOfTeams > 0) {
            HasTeams = true;
        }
        for (int i = 0; i < this.NumberOfTeams; i++) {
            if (this.Teams[i].getLeader().getType() == EmployeeType.MANAGER) {
                HasManager = true;
            }
        }
        DateIsValid = today.isAfter(this.Expiration_Date);
        if (HasTeams == true && DateIsValid == true && HasManager == true) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Equipments getEquipments() {
        Equipments[] ListOfEquipments = new Equipments[this.NumberOfEquipments];
        for (int i = 0; i < this.NumberOfEquipments; i++) {
            ListOfEquipments[i] = (Equipments) this.Equipment[i];
        }
        //return ListOfEquipments;
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String toString() {
        return "NOME: " + this.Name + "\nLOCALIZAÇÃO: " + this.Location + "\nPERMIT: " + this.Permit
                + "\nDATA DE EXPIRAÇÃO: " + this.Expiration_Date + "\nNÚMERO DE EQUIPAS: " + this.NumberOfTeams + "\nNÚMERO DE EQUIPAMENTOS: " + this.NumberOfEquipments + "\nVALIDA: " + this.isValid()
                + "\n==============================";
    }

}
