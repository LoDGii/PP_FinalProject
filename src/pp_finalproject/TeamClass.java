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

import estgconstroi.Employee;
import estgconstroi.Equipment;
import estgconstroi.Equipments;
import estgconstroi.Team;
import estgconstroi.enums.EmployeeType;
import estgconstroi.exceptions.ConstructionSiteException;
import estgconstroi.exceptions.TeamException;

/**
 * Classe que representa uma equipa
 *
 * @author Bruno
 * @author Diogo
 */
public class TeamClass implements Team {

    /**
     * Atributos de uma equipa
     */
    private String name;
    private Employee leader;
    private int numberEmployees;
    private EmployeeClass[] employee;
    private int numberEquipment;
    private Equipments equipment;
    private TeamStatus status;

    /**
     * metodo construtor de uma equipa
     *
     * @param name
     */
    public TeamClass(String name) {
        this.name = name;
        this.numberEmployees = 0;
        this.numberEquipment = 0;
        this.employee = new EmployeeClass[10];
        this.status = TeamStatus.FREE;
    }

    /**
     * retorna o nome da equipa
     *
     * @return
     */
    @Override
    public String getName() {
        String copy = this.name;
        return copy;
    }

    /**
     * metodo que atribui um nome a uma equipa
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public TeamStatus getStatus() {
        return this.status;
    }

    /**
     * metodo que retorna o lider de uma equipa
     *
     * @return
     */
    @Override
    public Employee getLeader() {
        Employee copy = this.leader;
        return copy;
    }

    /**
     * metodo que atribui um lider a uma equipa
     *
     * @param empl
     * @throws TeamException
     */
    @Override
    public void setLeader(Employee empl) throws TeamException {
        try {
            this.leader = empl;
        } catch (Exception o) {
            throw new TeamException("Erro ao fazer set no Team Leader");
        }
    }

    /**
     * metodo que retorna o numero de empregados dentro da equipa
     *
     * @return
     */
    @Override
    public int getNumberOfEmployees() {
        return this.numberEmployees;
    }

    /**
     * metodo que verifica o tamanho de uma equipa e se necessario vai aumentar
     * o tamanho do array que tem os empregados
     */
    private void verifySize() {
        if (this.employee.length == numberEmployees) {
            EmployeeClass[] newArray = new EmployeeClass[numberEmployees];
            for (int i = 0; i < numberEmployees; i++) {
                newArray[i] = this.employee[i];
            }
            this.employee = new EmployeeClass[numberEmployees + 10];
            for (int i = 0; i < numberEmployees; i++) {
                this.employee[i] = newArray[i];
            }
        }
    }

    /**
     * metodo que adiciona um empregado a uma equipa
     *
     * @param empl
     * @throws TeamException
     */
    @Override
    public void addEmployees(Employee empl) throws TeamException {
        try {
            verifySize();
            boolean findequal = false;
            for (int i = 0; i < this.numberEmployees; i++) {
                if (empl.equals(this.employee[i]) == true) {
                    findequal = true;
                }
            }
            if (findequal == false) {
                this.employee[this.numberEmployees++] = (EmployeeClass) empl;
                System.out.println("Trabalhador adicionado");
            } else {
                System.out.println("Este trabalhador já existe nesta equipa");
            }
        } catch (Exception i) {
            throw new TeamException("Erro ao adicionar trabalhador");
        }
    }

    /**
     * metodo que remove um empregado de uma equipa
     *
     * @param empl
     * @throws TeamException
     */
    @Override
    public void removeEmployee(Employee empl) throws TeamException {
        try {
            boolean igual = false;
            int posicaoarray = -1;
            for (int i = 0; i < this.numberEmployees; i++) {
                if (empl.getUUID() == this.employee[i].getUUID()) {
                    igual = true;
                    posicaoarray = i;
                }
            }
            if (igual == true) {
                EmployeeClass[] array = new EmployeeClass[this.employee.length - 1]; //crio um novo array com menos uma posicao
                int k = 0;//variavel que vai incrementar 
                for (int i = 0; i < this.employee.length; i++) {//enquanto o i for menor que o tamanho do array
                    if (i != posicaoarray) { // e o i for diferente da posicao recebida
                        array[k] = this.employee[i];//o array guarda o que tá no array original
                        k++;
                    }
                }
                this.employee = array; //depois copio a cópia para o original
                this.numberEmployees--;
                System.out.println("Trabalhador foi removido com sucesso");
            } else {
                System.out.println("Impossivel remover porque o trabalhador " + empl.getName() + " nao  nesta equipa");
            }
        } catch (Exception i) {
            throw new TeamException("Erro ao remover trabalhador");
        }
    }

    /**
     * metodo que retorna um array de empregados com o mesmo nome que estão
     * dentro de uma equipa
     *
     * @param name
     * @return
     */
    @Override
    public Employee[] getEmployees(String name) {
        int contador = 0;
        for (int i = 0; i < this.numberEmployees; i++) {
            if (name.toUpperCase().equals(this.employee[i].getName().toUpperCase())) {
                contador++;
            }
        }

        EmployeeClass[] array = new EmployeeClass[contador];
        contador = 0;

        for (int i = 0; i < this.numberEmployees; i++) {
            if (name.toUpperCase().equals(this.employee[i].getName().toUpperCase())) {
                array[contador] = this.employee[i];
                contador++;
            }
        }
        return array;
    }

    /**
     * metodo que retorna um array com empregados de um certo tipo
     *
     * @param et
     * @return
     */
    @Override
    public Employee[] getEmployees(EmployeeType et) {
        int contador = 0;
        for (int i = 0; i < this.numberEmployees; i++) {
            if (et == (this.employee[i].getType())) {
                contador++;
            }
        }

        EmployeeClass[] array = new EmployeeClass[contador];
        contador = 0;

        for (int i = 0; i < this.numberEmployees; i++) {
            if (et == (this.employee[i].getType())) {
                array[contador] = this.employee[i];
                contador++;
            }
        }
        return array;
    }

    /**
     * metodo que retorna todos os empregados que estão dentro de uma equipa
     *
     * @return
     */
    @Override
    public Employee[] getEmployees() {
        Employee[] copy = new Employee[this.employee.length];
        for (int i = 0; i < this.numberEmployees; i++) {
            copy[i] = this.employee[i];
        }
        return copy;
    }

    /**
     * metodo que retorna os equipamentos que estão dentro da equipa
     *
     * @return
     */
    @Override
    public Equipments getEquipments() {
        Equipments copy = this.equipment;
        return copy;
    }

    /**
     * metodo que adiciona um equipamento a equipa
     *
     * @param eqpmnt
     * @throws ConstructionSiteException
     */
    public void addEquipments(Equipment eqpmnt) throws ConstructionSiteException {
        this.equipment.addEquipment(eqpmnt);
        this.numberEquipment++;
    }

    public void setStatus(TeamStatus stat) {
        this.status = stat;
    }

}
