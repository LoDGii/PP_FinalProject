/*
* Nome: Bruno Miguel Rodrigues Novais
* Número: 8210333
* Turma: LEI12T1
*
* Nome: Diogo Gomes Cardoso
* Número: 8210193
* Turma: LEI12T1
*/

package pp_finalproject;

import estgconstroi.ConstructionSite;
import estgconstroi.Employee;
import estgconstroi.Equipment;
import estgconstroi.Equipments;
import estgconstroi.Team;
import estgconstroi.enums.EmployeeType;
import estgconstroi.exceptions.ConstructionSiteException;
import java.time.LocalDate;

/**
 * This class provides all the atributes needed to create a Construction Site.
 * 
 * 
 */
public class ConstructionSiteClass implements ConstructionSite {

    /**
     * @param Name Name of the Construction Site.
     * @param Location Location of the Construction Site.
     * @param Permit Permit of the Construction Site.
     * @param Expiration_Date Expiration Date of the construction site.
     * @param Teams List of teams that work in this construction site.
     * @param Equipment List of equipments that are assigned to this construction site.
     * @param NumberOfTeams Number of teams assigned to this construction site.
     * @param NumberOfEquipments Number of equipments assigned to this construction site.
     * 
     */
    private String Name; 
    private String Location;
    private String Permit;
    private LocalDate Expiration_Date;
    private LocalDate Start_Date;
    private EmployeeClass Responsible;
    private TeamClass[] Teams;
    private Equipments Equipment;
    private int NumberOfTeams;
    private int NumberOfEquipments;
    private LocalDate Permit_Expiration;
    
    
    /**
     * Constructor Method 
     * @param TempName Stores the name of the Construction site.
     * @param TempLocation Stores the location of the construction site.
     * @param TempExpirationDates Stores the expiration date of the construction site.
     * @param TempPermit Stores the permit of the construction site.
     */
    public ConstructionSiteClass(String TempName, String TempLocation, LocalDate TempExpirationDate, String TempPermit) {
        this.Name = TempName;
        this.Location = TempLocation;
        this.Expiration_Date = TempExpirationDate;
        this.NumberOfEquipments = 0;
        this.NumberOfTeams = 0;
        this.Permit = TempPermit;
    }
    /**
     * Return's the name of the construction site.
     * @return name of the construction site.
     */
    @Override
    public String getName() {
        return this.Name;
    }
    /**
     * Returns the location of the construction site.
     * @return location of the construction site
     */
    @Override
    public String getLocation() {
        return this.Location;
    }
    /**
     * Return's the permit of the construction site
     * @return permit of the construction site
     */
    @Override
    public String getPermit() {
        return this.Permit;
    }
    /**
     * 
     * @return Permit Expiration Date of the construction site
     */
    @Override
    public LocalDate getPermitExpirationDate() {
        return this.Expiration_Date;
    }
/**
 * 
 * @return start date of the construction site 
 */
    @Override
    public LocalDate getStartDate() {
        return this.Start_Date;
    }
/**
 * 
 * @return end date of the construction 
 */
    @Override
    public LocalDate getEndDate() {
        return this.Expiration_Date;
    }
/**
 * Set permit of a given construction site
 * @param string permit
 * @param ld date of the permit
 */
    @Override
    public void setPermit(String string, LocalDate ld) {
        this.Permit = string;
        this.Expiration_Date = ld;
    }


/**
 * 
 * @return responsible for the construction site 
 */
    @Override
    public Employee getResponsible() {
        EmployeeClass responsable = new EmployeeClass();
        responsable = this.Responsible;
        return responsable;
    }
/**
 * Set the construction site responsible.
 * @param empl Employee to be set responsible for the construction site
 * @throws ConstructionSiteException 
 */
    @Override
    public void setResponsible(Employee empl) throws ConstructionSiteException {
        try {
            this.Responsible = (EmployeeClass) empl;

        } catch (Exception exc) {
            throw new ConstructionSiteException("NÃO FOI POSSIVEL NOMEAR ESTE RESPONSÁVEL!");
        }

    }
/**
 * Add team to a construction site
 * @param team team to be assigned to the construction site
 * @throws ConstructionSiteException 
 */
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
/**
 * Remove team from a construction site
 * @param team team to be removed from a construction site
 * @throws ConstructionSiteException 
 */
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
/**
 * Get Teams with the same name as given
 * @param string name to be compared with the team name's
 * @return team's with the same name as the one given
 */
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
    /**
     * 
     * @return all the teams assigned to the construction site
     */
    @Override
    public Team[] getTeams() {
        return this.Teams;
    }
/**
 * If the construction site <b>HAS TEAMS</b>, <b>HAS A VALID DATE<\b> and <b>HAS A MANAGER ASSIGNED</b>
 * is valid, It's invalid otherwise.
 * @return true if construction is valid, false if not.
 */
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
    /**
     * 
     * @return equipments assigned to the construction site.
     */
    @Override
    public Equipments getEquipments() {
       return this.Equipment;
        
    }
/**
 * 
 * @return values from the construction site in a string form
 */
    @Override
    public String toString() {
        return "NOME: " + this.Name + "\nLOCALIZAÇÃO: " + this.Location + "\nPERMIT: " + this.Permit
                + "\nDATA DE EXPIRAÇÃO: " + this.Expiration_Date + "\nNÚMERO DE EQUIPAS: " + this.NumberOfTeams + "\nNÚMERO DE EQUIPAMENTOS: " + this.NumberOfEquipments + "\nVALIDA: " + this.isValid()
                + "\n==============================";
    }
    /**
     * Assign an equipment to a construction site.
     * @param eqpmnt
     * @throws ConstructionSiteException 
     */
    public void addEquipments(Equipment eqpmnt) throws ConstructionSiteException{
        this.Equipment.addEquipment(eqpmnt);
    }

    
    /**
     * Remove a given equipment from the construction site
     * @param eqpmnt equipment to be removed from the construction site
     * @throws ConstructionSiteException 
     */
    public void removeEquipment(Equipment eqpmnt) throws ConstructionSiteException{
        this.Equipment.removeEquipment(eqpmnt);
    }
}
