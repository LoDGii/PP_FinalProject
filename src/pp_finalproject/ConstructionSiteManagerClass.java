/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.ConstructionSite;
import estgconstroi.ConstructionSiteManager;
import estgconstroi.Equipment;
import estgconstroi.Equipments;
import estgconstroi.Team;
import estgconstroi.enums.EquipmentStatus;
import estgconstroi.exceptions.ConstructionSiteManagerException;
import java.time.LocalDate;
import java.util.Arrays;

/**
 *
 * @author Utilizador
 */
public class ConstructionSiteManagerClass implements ConstructionSiteManager {

    private int NumberOfConstructions = 0;
    protected ConstructionSiteClass[] ConstructionSites;

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
    public Equipment[] getAllEquipments(){
        Equipments[] FakeArray = new Equipments[this.NumberOfConstructions];
        FakeArray[0] = this.ConstructionSites[0].getEquipments(); //aqui tinha um bug, estava a usar i e quero 0       
        for (int i = 1; i < this.NumberOfConstructions; i++) {
            FakeArray[i] = this.ConstructionSites[i].getEquipments();
        }
        return (Equipment[]) FakeArray;
    }
    public Team[] getAllTeams() {
        Team[] FakeArray = new Team[this.NumberOfConstructions];
        FakeArray = this.ConstructionSites[0].getTeams(); //aqui tinha um bug, estava a usar i e quero 0       
        for (int i = 1; i < this.NumberOfConstructions; i++) {
            FakeArray = this.ConstructionSites[i].getTeams();
        }
        return FakeArray;
    }

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

    @Override
    public boolean isValid() {
        return true;
    }

    static <T> T[] concatWithArrayCopy(T[] array1, T[] array2) {
        T[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }

    public void remove(int index_remove) {
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
                }
            }
            this.ConstructionSites = FakeArray;
        }
    }

    public void showAllConstructionSites() {
        if (this.NumberOfConstructions == 0) {
            System.out.println("\nNÃO EXISTEM CONSTRUÇÕES PARA MOSTRAR!");
        } else {
            System.out.println("\n========== LISTA DE CONSTRUÇÕES ==========");
            for (int i = 0; i < this.NumberOfConstructions; i++) {
                System.out.println(this.ConstructionSites[i].toString());
            }
        }
    }

    public int[] getNumberOfEquipments() {
        int[] NumberOfEquipments = new int[this.NumberOfConstructions];

        Equipment[] FakeArray;
        for (int i = 0; i < this.NumberOfConstructions; i++) {
            FakeArray = this.ConstructionSites[i].getEquipments().getEquipment();
            NumberOfEquipments[i] = FakeArray.length;
        }
        return NumberOfEquipments;
    }

    public ConstructionSiteClass[] getConstructionSites() {
        return this.ConstructionSites;
    }

    public int getNumberOfConstructionSites() {
        return this.NumberOfConstructions;
    }

}
