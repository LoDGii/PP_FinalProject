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

    private Employee[] ListOfEmployees;
    private int NumberOfEmployees = 0;

    public void add(Employee emp) {
        Employee[] FakeArray = new Employee[this.NumberOfEmployees + 1];
        for (int i = 0; i < this.NumberOfEmployees; i++) {
            FakeArray[i] = this.ListOfEmployees[i];
        }
        FakeArray[this.NumberOfEmployees] = emp;
        NumberOfEmployees++;
        this.ListOfEmployees = FakeArray;
    }

    public Employee[] getManagers() {
        Employee[] ListManager = new Employee[this.NumberOfEmployees];
        int k = 0;
        for (int i = 0; i < this.NumberOfEmployees; i++) {
            if (this.ListOfEmployees[i].getType() == EmployeeType.MANAGER) {
                ListManager[k] = this.ListOfEmployees[i];
                k++;
            }
        }
        Employee[] FinalManagerList = new Employee[k + 1];
        for (int i = 0; i < k + 1; i++) {
            FinalManagerList[i] = ListManager[i];
        }
        return FinalManagerList;

    }
}
