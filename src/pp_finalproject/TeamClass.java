/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.Employee;
import estgconstroi.Equipments;
import estgconstroi.Team;
import estgconstroi.enums.EmployeeType;
import estgconstroi.exceptions.TeamException;

/**
 *
 * @author Utilizador
 */
public class TeamClass implements Team{
      private String name;
      private Employee leader;
      private int numberEmployees;
      private EmployeeClass[] employee;
      
      
    @Override
    public String getName() {
        String copy = this.name;
        return copy;
    }

    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public Employee getLeader() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setLeader(Employee empl) throws TeamException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getNumberOfEmployees() {
        return this.numberEmployees;
    }

    
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

    @Override
    public void removeEmployee(Employee empl) throws TeamException {
        try {
            boolean igual = false;
            int posicaoarray = -1;
            for (int i = 0; i < this.numberEmployees; i++) {
                if (empl.equals(this.employee[i]) == true) {
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

    @Override
    public Employee[] getEmployees() {
        return this.employee;
    }

    @Override
    public Equipments getEquipments() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}