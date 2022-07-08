/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_finalproject;

import estgconstroi.Employee;
import estgconstroi.enums.EmployeeType;

/**
 *
 * @author Utilizador
 */
public class EmployeeManagerClass {

    private EmployeeClass[] ListOfEmployees;
    private int NumberOfEmployees = 0;

    public int getNumebrOfEmployees(){
        return this.NumberOfEmployees;
    }
    
    public void add(Employee emp) {
        EmployeeClass[] FakeArray = (EmployeeClass[]) new Employee[this.NumberOfEmployees + 1];
        for (int i = 0; i < this.NumberOfEmployees; i++) {
            FakeArray[i] = this.ListOfEmployees[i];
        }
        FakeArray[this.NumberOfEmployees] = (EmployeeClass) emp;
        NumberOfEmployees++;
        this.ListOfEmployees = (EmployeeClass[]) FakeArray;
    }
    public void setName(String TempName, int Index){
        this.ListOfEmployees[Index].setName(TempName);
    }
    public Employee[] getEmployees() {
        EmployeeClass[] FakeArray = (EmployeeClass[]) new Employee[this.NumberOfEmployees];
        System.arraycopy(this.ListOfEmployees, 0, FakeArray, 0, this.NumberOfEmployees);
        return FakeArray;
    }

    public Employee[] getEmployees(EmployeeType type) {

        EmployeeClass[] ListManager = (EmployeeClass[]) new Employee[this.NumberOfEmployees];
        int k = 0;
        for (int i = 0; i < this.NumberOfEmployees; i++) {
            if (this.ListOfEmployees[i].getType() == type) {
                ListManager[k] = this.ListOfEmployees[i];
                k++;
            }
        }
        EmployeeClass[] FinalManagerList = (EmployeeClass[]) new Employee[k + 1];
        for (int i = 0; i < k + 1; i++) {
            FinalManagerList[i] = ListManager[i];
        }
        return FinalManagerList;

    }

    public void setType(EmployeeType TempType, int Index){
        this.ListOfEmployees[Index].setType(TempType);
    }
    
    
public Employee[] getManagers() {
        EmployeeClass[] ListManager = (EmployeeClass[]) new Employee[this.NumberOfEmployees];
        int k = 0;
        for (int i = 0; i < this.NumberOfEmployees; i++) {
            if (this.ListOfEmployees[i].getType() == EmployeeType.MANAGER) {
                ListManager[k] = this.ListOfEmployees[i];
                k++;
            }
        }
        EmployeeClass[] FinalManagerList = (EmployeeClass[]) new Employee[k + 1];
        for (int i = 0; i < k + 1; i++) {
            FinalManagerList[i] = ListManager[i];
        }
        return FinalManagerList;

    }
}
