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

import estgconstroi.enums.EmployeeType;
import java.util.Scanner;

/**
 *
 * Class with all the arguments for the Employee's menu.
 */
public class EmployeeMenu {

    /**
     * Principal Employee's Menu. The user can <b>create, edit and see</b> the
     * Employees
     *
     * @param emp variable with all the information of the employees in the
     * company.
     */
    public void principalMenu(EmployeeManagerClass emp) {
        Scanner Read = new Scanner(System.in);
        int Choice = -1;
        do {
            System.out.println("========== MENU DE FUNCIONÁRIOS ==========");
            System.out.println("1 - CRIAR FUNCIONÁRIO");//DONE
            System.out.println("2 - MOSTRAR LISTA DE FUNCIONÁRIOS");//DONE
            System.out.println("3 - EDITAR FUNCIONÁRIO");//DONE
            System.out.println("0 - VOLTAR AO MENU INICIAL");//DONE
            System.out.println("==========================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > 3);
        switch (Choice) {
            case 0:
                break;
            case 1:
                createEmployeeMenu(emp);
                principalMenu(emp);
                break;
            case 2:
                showAllEmployees(emp);
                principalMenu(emp);
                break;
            case 3:
                editEmployee(emp);
                principalMenu(emp);
                break;
        }
    }

    /**
     * Create's a new Employee
     *
     * @param emp variable with all the information of the employees in the
     * company.
     */
    public void createEmployeeMenu(EmployeeManagerClass emp) {
        Scanner Read = new Scanner(System.in);
        String TempName;
        int Choice = 0;
        EmployeeType type = EmployeeType.WORKER;
        System.out.println("NOME: ");
        TempName = Read.next();
        do {
            System.out.println("========== CARGO A OCUPAR ==========");
            System.out.println("1 - TRABALHADOR");
            System.out.println("2 - GESTOR");
            System.out.println("3 - LIDER DE EQUIPA");
            System.out.println("=====================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > 3);
        if (Choice == 1) {
            type = EmployeeType.WORKER;
        } else if (Choice == 2) {
            type = EmployeeType.MANAGER;
        } else if (Choice == 3) {
            type = EmployeeType.TEAM_LEADER;
        }

        EmployeeClass empl = new EmployeeClass(TempName, type);
        emp.add(empl);
        
    }

    /**
     * Show's all the Employees in the Company
     *
     * @param emp variable with all the information of the employees in the
     * company.
     */
    public void showAllEmployees(EmployeeManagerClass emp) {
        EmployeeClass[] employees = emp.getEmployees();
        Scanner Read = new Scanner(System.in);
        int Choice = 1;
        do {
            System.out.println("========== LISTA DE FUNCIONÁRIOS ==========");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(i + 1 + " - " + employees[i].getName() + " - " + employees[i].getType() + " - " + employees[i].getUUID());
            }
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");
            System.out.println("============================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice != 0);
        principalMenu(emp);
    }

    /**
     * Edit the name and type of an Employee with the methods <b>setName()</b>
     * and <b>setType()</b>.
     *
     * @param emp variable with all the information of the employees in the
     * company.
     */
    public void editEmployee(EmployeeManagerClass emp) {
        Scanner Read = new Scanner(System.in);
        int IndexEmployee = getEmployeeToChange(emp);
        String TempName;
        EmployeeType type = null;
        int Choice;
        do {
            System.out.println("============ EDITAR FUNCIONÁRIO ==========");
            System.out.println("1 - ALTERAR NOME");
            System.out.println("2 - ALTERAR FUNÇÃO");
            System.out.println("0 - VOLTAR ATRÁS");
            System.out.println("===========================================");
            System.out.println("OPÇÃO: ");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > 2);
        switch (Choice) {
            case 0:
                principalMenu(emp);
                break;
            case 1:
                System.out.println("NOME: ");
                TempName = Read.next();
                emp.setName(TempName, IndexEmployee);
                principalMenu(emp);
                break;
            case 2:
                do {
                    System.out.println("========== CARGO A OCUPAR ==========");
                    System.out.println("1 - TRABALHADOR");
                    System.out.println("2 - GESTOR");
                    System.out.println("3 - LIDER DE EQUIPA");
                    System.out.println("=====================================");
                    System.out.println("OPÇÃO: ");
                    Choice = Read.nextInt();
                } while (Choice < 0 || Choice > 3);
                if (Choice == 1) {
                    type = EmployeeType.WORKER;
                } else if (Choice == 2) {
                    type = EmployeeType.MANAGER;
                } else if (Choice == 3) {
                    type = EmployeeType.TEAM_LEADER;
                }
                emp.setType(type, IndexEmployee);
        }
    }

    /**
     * We get the Index of the employee the user wants to change.
     * <p>
     * First we assign all the teams in the variable empl and show their name
     * and UUID.
     * <p>
     * After that the choice the user makes will be equal to the index plus one
     * of the employee.
     *
     *
     *
     * @param emp variable with all the information of the employees in the
     * company.
     * @return index of the employee the user wants to edit.
     */
    public int getEmployeeToChange(EmployeeManagerClass emp) {
        EmployeeClass[] empl = emp.getEmployees();
        Scanner Read = new Scanner(System.in);
        int Choice, Index;
        do {
            System.out.println("========== LISTA DE FUNCIONÁRIOS ==========");
            for (int i = 0; i < empl.length; i++) {
                System.out.println(i + 1 + " - " + empl[i].getName() + " - " + empl[i].getUUID());
            }
            System.out.println("0 - VOLTAR AO MENU ANTERIOR");
            System.out.println("===========================================");
            Choice = Read.nextInt();
        } while (Choice < 0 || Choice > empl.length);
        switch (Choice) {
            case 0:
                break;

            default:
                Index = Choice - 1;
                return Index;

        }
        principalMenu(emp);
        return 0;
    }

}
