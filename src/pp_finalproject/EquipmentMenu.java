/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.Equipment;
import estgconstroi.enums.EquipmentStatus;
import estgconstroi.enums.EquipmentType;
import estgconstroi.exceptions.ConstructionSiteException;
import estgconstroi.exceptions.ConstructionSiteManagerException;
import java.util.Scanner;

/**
 *
 * @author Utilizador
 */
public class EquipmentMenu {

    public void EquipmentsMenu(EquipmentsClass equip) throws ConstructionSiteManagerException, ConstructionSiteException {
        Scanner Read = new Scanner(System.in);
        int choice;
        do {
            System.out.println("========== MENU DE EQUIPAS ==========");
            System.out.println("1 - CRIAR NOVO EQUIPAMENTO");
            System.out.println("2 - REMOVER EQUIPAMENTO");
            System.out.println("3 - LISTAR EQUIPAMENTOS PELO NOME");
            System.out.println("4 - LISTAR EQUIPAMENTOS PELO TIPO");
            System.out.println("5 - LISTAR EQUIPAMENTOS PELO ESTADO");
            System.out.println("6 - EDITAR EQUIPAMENTO AINDA NÃO CONFIRMADO");
            System.out.println("0 - SAIR");
            System.out.println("==========================================");
            choice = Read.nextInt();
        } while (choice < 0 || choice > 4);
        switch (choice) {
            case 0:
                break;
            case 1:
                //criarEquipment(equip);
                break;
            case 2:
                //removerEquipment(equip);
                break;
            case 3:
                //showEquipName(equip);
                break;
            case 4:
                //showEquipType(equip);
                break;
            case 5:
                //showEquipStatus(equip);
                break;
            case 6:
                editEquipment(equip);
                break;
        }
    }
    
    public void editEquipment(EquipmentsClass equip) throws ConstructionSiteManagerException, ConstructionSiteException{
        try{
            
            String TempNome;
            EquipmentType TempType = null;
            EquipmentStatus TempStatus = null;
            Scanner Read = new Scanner(System.in);
            int choice;
            if(equip.getNumberOfEquipments() != 0){
            do {
                for(int i = 0;i<equip.getNumberOfEquipments();i++){
                    if(equip.getEquipment()[i] != null){
                System.out.println(i + " Nome do equipamento a editar - " + equip.getEquipment()[i].getName());
                    }
                }
                choice = Read.nextInt();
            } while (choice < 1 || choice > equip.getNumberOfEquipments());
            
            System.out.println("Digite um novo nome do equipamento:");
            TempNome = Read.next();
            do {
                System.out.println("Introduza o novo tipo de equipamento: \n1 - TRANSPORT\n2 - TOOLS\n3 - MATERIALS\n4 - EQUIPMENT"
                        + "\n5 - HEAVY_DUTY\n6 - OTHER");
                choice = Read.nextInt();
            } while (choice < 1 || choice > 6);
            if (choice == 1) {
                TempType = EquipmentType.TRANSPORT;
            } else if (choice == 2) {
                TempType = EquipmentType.TOOLS;
            } else if (choice == 3) {
                TempType = EquipmentType.MATERIALS;
            } else if (choice == 4) {
                TempType = EquipmentType.EQUIPMENT;
            } else if (choice == 5) {
                TempType = EquipmentType.HEAVY_DUTY;
            } else if (choice == 6) {
                TempType = EquipmentType.OTHER;
            }
            do {
                System.out.println("Introduza o novo status do equipamento: \n1 - OPERATIVE\n2 - MAINTENANCE \n3 - INOPERATIVE");
                choice = Read.nextInt();
            } while (choice < 1 || choice > 3);
            if (choice == 1) {
                TempStatus = EquipmentStatus.OPERATIVE;
            } else if (choice == 2) {
                TempStatus = EquipmentStatus.MAINTENANCE;
            } else if (choice == 3) {
                TempStatus = EquipmentStatus.INOPERATIVE;
            }
            EquipmentClass TempEquipment = new EquipmentClass(TempNome, TempType, TempStatus);
            equip.getEquipment()[choice] = TempEquipment;
            EquipmentsMenu(equip);       
            }else{
                System.out.println("Não existe equipamentos");
                EquipmentsMenu(equip);
            }
        }catch(Exception o){
            System.out.println(o.getMessage());
            EquipmentsMenu(equip);
                
        }
    }
    
    
    public void showEquipStatus(EquipmentsClass equip) throws ConstructionSiteManagerException, ConstructionSiteException {
        try {
            if(equip.getNumberOfEquipments() != 0){
            EquipmentStatus TempState = null;
            Scanner Read = new Scanner(System.in);
            int choice = 0;

            do {
                System.out.println("Introduza o tipo de status de equipamento que deseja procurar: \n1 - OPERATIVE"
                        + "\n2 - MAINTENANCE \n3 - INOPERATIVE");
                choice = Read.nextInt();
            } while (choice < 1 || choice > 3);
              if (choice == 1) {
                TempState = EquipmentStatus.OPERATIVE;
            } else if (choice == 2) {
                TempState = EquipmentStatus.MAINTENANCE;
            } else if (choice == 3) {
                TempState = EquipmentStatus.INOPERATIVE;
            }
              Equipment[] TempEquipment = equip.getEquipment(TempState);
              for (int i = 0; i < TempEquipment.length; i++) {
                if (TempEquipment[i] != null) {
                    System.out.println(i + " NOME -" + TempEquipment[i].getName());
                }
            }
            EquipmentsMenu(equip);
            }else{
                System.out.println("Não existe equipamentos.");
                EquipmentsMenu(equip);
            }
        } catch (Exception o) {
            System.out.println(o.getMessage());
            EquipmentsMenu(equip);
        }
    }
    
    
    
    public void showEquipType(EquipmentsClass equip) throws ConstructionSiteManagerException, ConstructionSiteException {
        try {
            if(equip.getNumberOfEquipments() !=0){
            EquipmentType TempType = null;

            Scanner Read = new Scanner(System.in);
            int choice = 0;
            do {
                System.out.println("Introduza o tipo de equipamento que deseja procurar: \n1 - TRANSPORT\n2 - TOOLS\n3 - MATERIALS\n4 - EQUIPMENT"
                        + "\n5 - HEAVY_DUTY\n6 - OTHER");
                choice = Read.nextInt();
            } while (choice < 1 || choice > 6);
            if (choice == 1) {
                TempType = EquipmentType.TRANSPORT;
            } else if (choice == 2) {
                TempType = EquipmentType.TOOLS;
            } else if (choice == 3) {
                TempType = EquipmentType.MATERIALS;
            } else if (choice == 4) {
                TempType = EquipmentType.EQUIPMENT;
            } else if (choice == 5) {
                TempType = EquipmentType.HEAVY_DUTY;
            } else if (choice == 6) {
                TempType = EquipmentType.OTHER;
            }
            Equipment[] TempEquip = equip.getEquipment(TempType);
            for (int i = 0; i < TempEquip.length; i++) {
                if (TempEquip[i] != null) {
                    System.out.println(i + " NOME -" + TempEquip[i].getName());
                }
            }
            EquipmentsMenu(equip);
            }else{
                System.out.println("Não existe quipamentos");
                EquipmentsMenu(equip);
            }
        } catch (Exception o) {
            System.out.println(o.getMessage());
            EquipmentsMenu(equip);
        }
    }
    
    public void showEquipName(EquipmentsClass equip) throws ConstructionSiteManagerException, ConstructionSiteException {
        try {
            if(equip.getNumberOfEquipments() != 0){
            String TempName;
            Scanner Read = new Scanner(System.in);
            System.out.println("Digite o nome do equipamento:");
            TempName = Read.next();
            Equipment[] TempEquipment = equip.getEquipment(TempName);
            for (int i = 0; i < TempEquipment.length; i++) {
                System.out.println(i + "-" + TempEquipment[i].getName());
            }
            }else{
                System.out.println("Não existem equipamentos");
                EquipmentsMenu(equip);
            }
        } catch (Exception o) {
            System.out.println(o.getMessage());
            EquipmentsMenu(equip);
        }
    }
    
    
    public void removerEquipment(EquipmentsClass equip) throws ConstructionSiteException, ConstructionSiteManagerException {
        try {
            Scanner Read = new Scanner(System.in);
            int choice;
            if(equip.getNumberOfEquipments() != 0){
            for (int i = 0; i < equip.getEquipment().length; i++) {
                if (equip.getEquipment()[i] != null) {
                    System.out.println(i + " NOME - " + equip.getEquipment()[i].getName());
                }
            }
            do {
                System.out.println("Escolha:");
                choice = Read.nextInt();
            } while (choice < 0 || choice > equip.getEquipment().length);
            equip.removeEquipment(equip.getEquipment()[choice]);
            EquipmentsMenu(equip);
            }else{
                System.out.println("Não existem equipamentos");
                EquipmentsMenu(equip);
            }
        } catch (Exception o) {
            System.out.println(o.getMessage());
            EquipmentsMenu(equip);
        }
    }
    
    public void criarEquipment(EquipmentsClass equip) throws ConstructionSiteException, ConstructionSiteManagerException {
        try {
            String TempNome;
            EquipmentType TempType = null;
            EquipmentStatus TempStatus = null;
            Scanner Read = new Scanner(System.in);
            int choice;
            System.out.println("Digite o nome do equipamento:");
            TempNome = Read.next();
            do {
                System.out.println("Introduza o tipo de equipamento: \n1 - TRANSPORT\n2 - TOOLS\n3 - MATERIALS\n4 - EQUIPMENT"
                        + "\n5 - HEAVY_DUTY\n6 - OTHER");
                choice = Read.nextInt();
            } while (choice < 1 || choice > 6);
            if (choice == 1) {
                TempType = EquipmentType.TRANSPORT;
            } else if (choice == 2) {
                TempType = EquipmentType.TOOLS;
            } else if (choice == 3) {
                TempType = EquipmentType.MATERIALS;
            } else if (choice == 4) {
                TempType = EquipmentType.EQUIPMENT;
            } else if (choice == 5) {
                TempType = EquipmentType.HEAVY_DUTY;
            } else if (choice == 6) {
                TempType = EquipmentType.OTHER;
            }
            do {
                System.out.println("Introduza o status do equipamento: \n1 - OPERATIVE\n2 - MAINTENANCE \n3 - INOPERATIVE");
                choice = Read.nextInt();
            } while (choice < 1 || choice > 3);
            if (choice == 1) {
                TempStatus = EquipmentStatus.OPERATIVE;
            } else if (choice == 2) {
                TempStatus = EquipmentStatus.MAINTENANCE;
            } else if (choice == 3) {
                TempStatus = EquipmentStatus.INOPERATIVE;
            }
            EquipmentClass TempEquipment = new EquipmentClass(TempNome, TempType, TempStatus);
            equip.addEquipment(TempEquipment);
            EquipmentsMenu(equip);
        } catch (Exception o) {
            System.out.println(o.getMessage());
            EquipmentsMenu(equip);
        }
    }
    
    
    
}
