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

import estgconstroi.Equipment;
import estgconstroi.enums.EquipmentStatus;
import estgconstroi.enums.EquipmentType;

/**
 *classe de equipamento
 * @author Bruno
 * @author Diogo
 */
public class EquipmentClass implements Equipment{
    /**
     * atriutos de um equipamento
     */
    private String Name;
    private EquipmentType Type;
    private EquipmentStatus Status;
    
    /**
     * metodo construtor para um equipamento
     * @param TempName
     * @param TempType
     * @param TempStatus 
     */
    public EquipmentClass(String TempName, EquipmentType TempType, EquipmentStatus TempStatus){
        this.Name = TempName;
        this.Type = TempType;
        this.Status = TempStatus;
    }
    /**
     * metodo que retona o nome de um equipamento
     * @return 
     */
    @Override
    public String getName() {
        return this.Name;
    }
/**
 * metodo que retorna o tipo de um equipamento
 * @return 
 */
    @Override
    public EquipmentType getType() {
        return this.Type;
    }
/**
 * metodo que retorna o estado do equipamento
 * @return 
 */
    @Override
    public EquipmentStatus getStatus() {
        return this.Status;
    }
/**
 * metodo que atribui um estado a um equipamento
 * @param es 
 */
    @Override
    public void setStatus(EquipmentStatus es) {
        this.Status = es;
    }

}
