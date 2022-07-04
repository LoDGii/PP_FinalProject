/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.Equipment;
import estgconstroi.Equipments;
import estgconstroi.enums.EquipmentStatus;
import estgconstroi.enums.EquipmentType;
import estgconstroi.exceptions.ConstructionSiteException;

/**
 *
 * @author Utilizador
 */
public class EquipmentsClass implements Equipments {

    private EquipmentClass[] equipments;
    private int numberEquipments;

    public EquipmentsClass() {
        this.numberEquipments = 0;
        this.equipments = new EquipmentClass[10];
    }

    private void verifySize() {
        if (this.equipments.length == this.numberEquipments) {
            EquipmentClass[] newArray = new EquipmentClass[this.numberEquipments];
            for (int i = 0; i < this.numberEquipments; i++) {
                newArray[i] = this.equipments[i];
            }
            this.equipments = new EquipmentClass[this.numberEquipments + 10];
            for (int i = 0; i < this.numberEquipments; i++) {
                this.equipments[i] = newArray[i];
            }
        }
    }

    @Override
    public void addEquipment(Equipment eqpmnt) throws ConstructionSiteException {
        try {
            verifySize();
            boolean findequal = false;
            for (int i = 0; i < this.numberEquipments; i++) {
                if (eqpmnt.equals(this.equipments[i]) == true) {
                    findequal = true;
                }
            }
            if (findequal == false) {
                this.equipments[this.numberEquipments++] = (EquipmentClass) eqpmnt;
                System.out.println("Equipamento foi adicionado");
            } else {
                System.out.println("Este equipamento já existe nesta caixa de ferramentas");
            }
        } catch (Exception o) {
            throw new ConstructionSiteException("Erro ao adicionar o equipamento");
        }
    }

    @Override
    public void removeEquipment(Equipment eqpmnt) throws ConstructionSiteException {
        try {
            boolean igual = false;
            int posicaoarray = -1;
            for (int i = 0; i < this.numberEquipments; i++) {
                if (eqpmnt.equals(this.equipments[i]) == true) {
                    igual = true;
                    posicaoarray = i;
                }
            }
            if (igual == true) {
                EquipmentClass[] array = new EquipmentClass[this.equipments.length - 1]; //crio um novo array com menos uma posicao
                int k = 0;//variavel que vai incrementar 
                for (int i = 0; i < this.equipments.length; i++) {//enquanto o i for menor que o tamanho do array
                    if (i != posicaoarray) { // e o i for diferente da posicao recebida
                        array[k] = this.equipments[i];//o array guarda o que tá no array original
                        k++;
                    }
                }
                this.equipments = array; //depois copio a cópia para o original
                this.numberEquipments--;
                System.out.println("Equipamento foi removido com sucesso");
            } else {
                System.out.println("Impossivel remover o equipamento " + eqpmnt.getName() + " pois não esta na caixa de ferramentas");
            }
        } catch (Exception o) {
            throw new ConstructionSiteException("Erro ao remover o equipamento");
        }
        
        
    }

    @Override
    public Equipment[] getEquipment(String string) {
        int contador = 0;
        for (int i = 0; i < this.numberEquipments; i++) {
            if (string.toUpperCase().equals(this.equipments[i].getName().toUpperCase())) {
                contador++;
            }
        }

        EquipmentClass[] array = new EquipmentClass[contador];
        contador = 0;

        for (int i = 0; i < this.numberEquipments; i++) {
            if (string.toUpperCase().equals(this.equipments[i].getName().toUpperCase())) {
                array[contador] = this.equipments[i];
                contador++;
            }
        }
        return array;       
    }

    @Override
    public Equipment[] getEquipment(EquipmentStatus es) {
        int contador = 0;
        for (int i = 0; i < this.numberEquipments; i++) {
            if (es == (this.equipments[i].getStatus())) {
                contador++;
            }
        }

        EquipmentClass[] array = new EquipmentClass[contador];
        contador = 0;

        for (int i = 0; i < this.numberEquipments; i++) {
            if (es == (this.equipments[i].getStatus())) {
                array[contador] = this.equipments[i];
                contador++;
            }
        }
        return array;
    }

    @Override
    public Equipment[] getEquipment(EquipmentType et) {
        int contador = 0;
        for (int i = 0; i < this.numberEquipments; i++) {
            if (et == (this.equipments[i].getType())) {
                contador++;
            }
        }

        EquipmentClass[] array = new EquipmentClass[contador];
        contador = 0;

        for (int i = 0; i < this.numberEquipments; i++) {
            if (et == (this.equipments[i].getType())) {
                array[contador] = this.equipments[i];
                contador++;
            }
        }
        return array;
    }

    @Override
    public Equipment[] getEquipment() {
         EquipmentClass[] copy = new EquipmentClass[this.equipments.length];
        for(int i = 0;i<this.numberEquipments;i++){
            copy[i] = this.equipments[i];
        }
        return copy;
    }

}
