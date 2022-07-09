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

import estgconstroi.ConstructionSite;
import estgconstroi.ConstructionSiteManager;
import estgconstroi.Employee;
import estgconstroi.Equipment;
import estgconstroi.Equipments;
import estgconstroi.Team;
import estgconstroi.enums.EquipmentStatus;
import estgconstroi.exceptions.ConstructionSiteException;
import estgconstroi.exceptions.ConstructionSiteManagerException;
import java.time.LocalDate;
import java.util.Arrays;

/**
 *
 * This class has all the params and methods to Manage all the Construction
 * sites of the Company.
 */
public class ConstructionSiteManagerClass implements ConstructionSiteManager {

    /**
     * @param NumberOfConstructions Number of Construction Sites
     * @param ConstructionSites Array with all the construction sites.
     */
    private int NumberOfConstructions = 0;
    protected ConstructionSiteClass[] ConstructionSites;

    /**
     * Add a Construction Site to the array
     *
     * @param cs Construction Site to be added
     * @throws ConstructionSiteManagerException
     */
    @Override
    public void add(ConstructionSite cs) throws ConstructionSiteManagerException {
        try {
            ConstructionSiteClass[] FakeArray = new ConstructionSiteClass[this.NumberOfConstructions + 1];
            for (int i = 0; i < this.NumberOfConstructions; i++) {
                FakeArray[i] = this.ConstructionSites[i];
            }
            FakeArray[this.NumberOfConstructions] = (ConstructionSiteClass) cs;
            this.ConstructionSites = FakeArray;
            this.NumberOfConstructions++;
        } catch (Exception o) {
            System.out.println(o.getMessage());
        }
    }

    /**
     *
     * @return teams working in a valid construction site.
     */
    @Override
    public Team[] getWorkingTeams() {
        Team[] FakeArray = this.ConstructionSites[0].getTeams(); //aqui tinha um bug, estava a usar i e quero 0       
        for (int i = 1; i < this.NumberOfConstructions; i++) {
            if (this.ConstructionSites[i].isValid() == true) {
                Team[] FakeArrayTwo = this.ConstructionSites[i].getTeams();
                FakeArray = concatWithArrayCopy(FakeArray, FakeArrayTwo);
            }
        }
        return FakeArray;

    }

    /**
     *
     * @return teams working in a non-valid construction site
     */
    @Override
    public Team[] getIddleTeams() {
        Team[] FakeArray = this.ConstructionSites[0].getTeams(); //aqui tinha um bug, estava a usar i e quero 0       
        for (int i = 1; i < this.NumberOfConstructions; i++) {
            if (this.ConstructionSites[i].isValid() == false) {
                Team[] FakeArrayTwo = this.ConstructionSites[i].getTeams();
                FakeArray = concatWithArrayCopy(FakeArray, FakeArrayTwo);
            }
        }
        return FakeArray;

    }

    /**
     *
     * @return all equipments working in a construction site
     */
    public Equipment[] getAllEquipments() {
        Equipments[] FakeArray = new Equipments[this.NumberOfConstructions];
        FakeArray[0] = this.ConstructionSites[0].getEquipments(); //aqui tinha um bug, estava a usar i e quero 0       
        for (int i = 1; i < this.NumberOfConstructions; i++) {
            FakeArray[i] = this.ConstructionSites[i].getEquipments();
        }
        return (Equipment[]) FakeArray;
    }

    /**
     *
     * @return all teams working in a construction site
     */
    public Team[] getAllTeams() {
        Team[] FakeArray = new Team[this.NumberOfConstructions];
        FakeArray = this.ConstructionSites[0].getTeams(); //aqui tinha um bug, estava a usar i e quero 0       
        for (int i = 1; i < this.NumberOfConstructions; i++) {
            FakeArray = this.ConstructionSites[i].getTeams();
        }
        return FakeArray;
    }

    /**
     *
     * @return equipments used in a valid construction site
     */
    @Override
    public Equipment[] getEquipmentsInUse() {
        Equipment[] AllEquipments;
        int NumberOfEquipments = 0;
        int k = 0;
        for (int i = 0; i < this.NumberOfConstructions; i++) {
            NumberOfEquipments += this.ConstructionSites[i].getEquipments().getEquipment().length;

        }
        Equipment[] IddleEquipments = new Equipment[NumberOfEquipments];
        int Index = 0;
        for (int i = 0; i < this.NumberOfConstructions; i++) {
            AllEquipments = this.ConstructionSites[i].getEquipments().getEquipment();
            for (k = 0; k < AllEquipments.length; k++) {
                if (AllEquipments[k].getStatus() == EquipmentStatus.OPERATIVE) {
                    IddleEquipments[Index] = AllEquipments[k];
                }
            }
        }
        Equipment[] FinalArray = new Equipment[k - 1];
        for (int i = 0; i < k; i++) {
            FinalArray[i] = IddleEquipments[i];
        }
        return FinalArray;

    }

    /**
     *
     * @return equipments used in a non-valid construction site
     */
    @Override
    public Equipment[] getIddleEquipments() {
        Equipment[] AllEquipments;
        int NumberOfEquipments = 0;
        int k = 0;
        for (int i = 0; i < this.NumberOfConstructions; i++) {
            NumberOfEquipments += this.ConstructionSites[i].getEquipments().getEquipment().length;

        }
        Equipment[] IddleEquipments = new Equipment[NumberOfEquipments];
        int Index = 0;
        for (int i = 0; i < this.NumberOfConstructions; i++) {
            AllEquipments = this.ConstructionSites[i].getEquipments().getEquipment();
            for (k = 0; k < AllEquipments.length; k++) {
                if (AllEquipments[k].getStatus() == EquipmentStatus.INOPERATIVE || AllEquipments[k].getStatus() == EquipmentStatus.MAINTENANCE) {
                    IddleEquipments[Index] = AllEquipments[k];
                }
            }
        }
        Equipment[] FinalArray = new Equipment[k - 1];
        for (int i = 0; i < k; i++) {
            FinalArray[i] = IddleEquipments[i];
        }
        return FinalArray;

    }

    /**
     *
     * @return construction sites with permit expired.
     */
    @Override
    public ConstructionSite[] getConstructionSitesWithPermitExpired() {
        LocalDate today = LocalDate.now();
        int NumberOfExpired = 0;
        ConstructionSite[] FakeArray = new ConstructionSite[this.NumberOfConstructions];
        for (int i = 0; i < this.NumberOfConstructions; i++) {
            if (this.ConstructionSites[i].getPermitExpirationDate().isBefore(today) == true) {
                FakeArray[NumberOfExpired] = this.ConstructionSites[i];
                NumberOfExpired++;
            }
        }
        ConstructionSite[] FakeArrayTwo = new ConstructionSite[NumberOfExpired];
        for (int i = 0; i < NumberOfExpired; i++) {
            FakeArrayTwo[i] = FakeArray[i];
        }
        return FakeArrayTwo;
    }

    /**
     *
     * @return if a construction site is valid
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /**
     * Concatnate two arrays.
     *
     * @param <T> result of the concatnation of <b>array1</b> and <b>array2</b>
     * @param array1 first array
     * @param array2 second array
     * @return result.
     */
    static <T> T[] concatWithArrayCopy(T[] array1, T[] array2) {
        T[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }

    /**
     * Remove a Construction Site.
     * <p>
     *
     *
     *
     * FALTA DEFINIR O TIPO PARA OS EQUIPAMENTOS E EQUIPAS!
     *
     *
     * @param index_remove Index of the construction site to be removed
     */
    public void remove(int index_remove, EmployeeManagerClass empl, TeamManagerClass team, EquipmentsClass equip) {
        ConstructionSiteClass[] FakeArray = new ConstructionSiteClass[this.NumberOfConstructions - 1];
        int k = 0;
        if (this.NumberOfConstructions == 1) {
            ConstructionSiteClass[] FakeArrayTwo = new ConstructionSiteClass[0];
            this.ConstructionSites = FakeArrayTwo;

        } else {
            for (int i = 0; i < this.NumberOfConstructions; i++) {
                if (i != index_remove) {
                    FakeArray[k] = this.ConstructionSites[i];
                    k++;

                } else {

                    Team[] teams = this.ConstructionSites[i].getTeams();
                    
                    for (int x = 0; x < teams.length; x++) {
                        EmployeeClass[] emp = (EmployeeClass[]) teams[x].getEmployees();
                        
                        team.setTeamStatus(x, TeamStatus.FREE);
                        for (int l = 0; l < emp.length; l++) {
                            int indexEmployee = empl.getEmployee(emp[l]);
                            empl.setEmployeeStatus(indexEmployee, EmployeeStatus.FREE);
                        }

                    }
                }
                this.ConstructionSites = FakeArray;
            }
        }
    }
        /**
         * Show's all the existent construction sites information
         */
    public void showAllConstructionSites() {
        if (this.NumberOfConstructions == 0) {
            System.out.println("\nNÃO EXISTEM CONSTRUÇÕES PARA MOSTRAR!");
        } else {
            System.out.println("\n========== LISTA DE CONSTRUÇÕES ==========");
            for (int i = 0; i < this.NumberOfConstructions; i++) {
                System.out.println(i + 1 + " - " + this.ConstructionSites[i].toString());
            }
        }
    }

    /**
     *
     * @return number of equipments associated with a construction site
     */
    public int[] getNumberOfEquipments() {
        int[] NumberOfEquipments = new int[this.NumberOfConstructions];

        Equipment[] FakeArray;
        for (int i = 0; i < this.NumberOfConstructions; i++) {
            FakeArray = this.ConstructionSites[i].getEquipments().getEquipment();
            NumberOfEquipments[i] = FakeArray.length;
        }
        return NumberOfEquipments;
    }

    /**
     *
     * @return all construction sites
     */
    public ConstructionSiteClass[] getConstructionSites() {
        return this.ConstructionSites;
    }

    /**
     *
     * @return number of construction sites
     */
    public int getNumberOfConstructionSites() {
        return this.NumberOfConstructions;
    }

    /**
     * Menu that shows all the Construction Sites
     *
     *
     */
    public void ListOfTeamsMenu() {
        int NumberOfConstructions = this.NumberOfConstructions;
        ;
        for (int i = 0; i < NumberOfConstructions; i++) {
            System.out.println((i + 1) + " - " + this.ConstructionSites[i].getName());
        }
    }
    
    public void ListOfTeamsMenu(int Index){
        Team[] teams = this.ConstructionSites[Index].getTeams();
        for(int i = 0;i < this.ConstructionSites[Index].getTeams().length;i++){
            System.out.println(i + 1 + " - " + teams[i].toString());
        }
    }

    /**
     *
     * Sets a new permit for the cs
     *
     *
     * @param Index index of the construction site to be removed
     * @param date new permit expiration date
     * @param TempPermit new permit
     */
    public void setPermit(int Index, LocalDate date, String TempPermit) {
        this.ConstructionSites[Index].setPermit(TempPermit, date);
    }
    
    /**
     * Return's the responsible for the construction site.
     * 
     * @param Index Index of the construction site to be checked
     */
    public Employee getResponsible(int Index){
        return this.ConstructionSites[Index].getResponsible();
    }
    
    /**
     * Set's the responsible for the construction site.
     * 
     * 
     * @param Index Index of the Construction Site to edit
     * @param empl employee to be set responsible
     * @throws ConstructionSiteException 
     */
    public void setResponsible(int Index, EmployeeClass empl) throws ConstructionSiteException{
        this.ConstructionSites[Index].setResponsible(empl);
    }

}
