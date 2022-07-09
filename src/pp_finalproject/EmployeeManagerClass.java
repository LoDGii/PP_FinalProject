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

import estgconstroi.Employee;
import estgconstroi.enums.EmployeeType;

/**
 * This class has all the params and methods to Manage all the Employees of the
 * Company.
 *
 */
public class EmployeeManagerClass {

    /**
     *
     *
     * @param ListOfEmployees array with every employee of the company.
     * @param NumberOfEmployees number of employees in the company.
     */
    private EmployeeClass[] ListOfEmployees;
    private int NumberOfEmployees = 0;

    /**
     * Return's the <h1>NumberOfEmployees</h1> param with the number of
     * employees in the company.
     *
     * @return number of employees in the company
     */
    public int getNumebrOfEmployees() {
        return this.NumberOfEmployees;
    }

    /**
     * Return's the EmployeeStatus of the selected Employee.
     *
     * @param Index Index of the Employee the user wants.
     * @return Employee Status.
     */
    public EmployeeStatus getEmployeeStatus(int Index) {
        return this.ListOfEmployees[Index].getStatus();
    }

    /**
     * Set's the Employee Status.
     *
     * @param Index Index of the employee the user want's to edit
     * @param stat Status of which the employee will get
     */
    public void setEmployeeStatus(int Index, EmployeeStatus stat) {
        this.ListOfEmployees[Index].setStatus(stat);
    }

    /**
     * Add's an Employee to the list of Employees. This method will create an
     * <h1>FakeArray</h1> with the side of <h2>NumberOfEmployees</h2> + 1 then
     * It will copy the employees from the <b>ListOfEmployees</b> and the last
     * value of the array will be given the value of the argument <b>emp</b>. At
     * the end the <b>ListOfEmployees</b> will be given the values of the
     * FakeArray.
     *
     * @param emp employee to be added to the list.
     */
    public void add(EmployeeClass emp) {
        EmployeeClass[] FakeArray = (EmployeeClass[]) new Employee[this.NumberOfEmployees + 1];
        System.arraycopy(this.ListOfEmployees, 0, FakeArray, 0, this.NumberOfEmployees);
        FakeArray[this.NumberOfEmployees] = (EmployeeClass) emp;
        NumberOfEmployees++;
        this.ListOfEmployees = (EmployeeClass[]) FakeArray;
    }

    /**
     * Set's the name of a given employee.
     *
     * @param TempName stores the Name to be given to the employee
     * @param Index Index of the employee the user want's to edit
     */
    public void setName(String TempName, int Index) {
        this.ListOfEmployees[Index].setName(TempName);
    }

    /**
     * Return's all the employees of the company.
     *
     * @return all employees of the company.
     */
    public EmployeeClass[] getEmployees() {
        EmployeeClass[] FakeArray = (EmployeeClass[]) new Employee[this.NumberOfEmployees];
        System.arraycopy(this.ListOfEmployees, 0, FakeArray, 0, this.NumberOfEmployees);
        return FakeArray;
    }

    /**
     * Return's all the employee's of a certain type.
     *
     * @param type Employee's Type to be searched for.
     * @return Employees of a given type.
     */
    public EmployeeClass[] getEmployees(EmployeeType type) {

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

    /**
     * Set's the Type of a given Employee
     *
     * @param TempType Type to be given to the employee
     * @param Index Index of the employee
     */
    public void setType(EmployeeType TempType, int Index) {
        this.ListOfEmployees[Index].setType(TempType);
    }

    /**
     * Set's the team of a given Employee.
     *
     * @param Index Index of the employee
     * @param tm Team to be assigned to the employee
     */
    public void setTeam(int Index, TeamClass tm) {
        this.ListOfEmployees[Index].setTeam(tm);
    }

    /**
     * Return's the Employee assignid in the <b>Index</b> of the array
     *
     * @param Index Index of the Employee
     * @return an employee
     */
    public EmployeeClass getEmployee(int Index) {
        return this.ListOfEmployees[Index];
    }

    /**
     * Returns an employee with the same UUID as the employee given.
     *
     * @param emp employee to compare in the list of employees
     * @return index of the employee with the same UUID.
     */
    public int getEmployee(Employee emp) {
        int index = -1;
        for (int i = 0; i < this.NumberOfEmployees; i++) {

            if (this.ListOfEmployees[i].getUUID().equals(emp.getUUID()) == true) {
                index = i;
            }
        }
        return index;
    }

    /**
     * 
     * Return's an array with the same type as in the arguments
     *
     * @param type type to be searched
     * @return array with the employees that has the same type as in the arguments
     */
    public EmployeeClass[] getEmployeeByType(EmployeeType type) {
        EmployeeClass[] emp = this.ListOfEmployees;
        EmployeeClass[] emp2 = new EmployeeClass[this.ListOfEmployees.length];
        int k = 0;
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getType() == type && emp[i].getStatus() == EmployeeStatus.FREE) {
                emp2[k] = emp[i];
                k++;
            }
        }
        emp = new EmployeeClass[k];
        System.arraycopy(emp2, 0, emp, 0, k);
        return emp;
    }

    /**
     * Return's an array with the employees with the same type <b>AND</b> status
     * as in the arguments.
     *
     * @param type type of employee to be searched
     * @param stat type of stat to be searched
     * @return array with the employee with the same type and status as in the arguments.
     */
    public EmployeeClass[] getEmployeeByTypeAndStatus(EmployeeType type, EmployeeStatus stat) {
        EmployeeClass[] FakeArray = new EmployeeClass[this.NumberOfEmployees];
        int k = 0;
        for (int i = 0; i < this.NumberOfEmployees; i++) {
            if (this.ListOfEmployees[i].getStatus() == stat && this.ListOfEmployees[i].getType() == type) {
                FakeArray[k] = this.ListOfEmployees[i];
                k++;
            }
        }
        EmployeeClass[] FakeArray2 = new EmployeeClass[k];
        System.arraycopy(FakeArray, 0, FakeArray2, 0, k);
        return FakeArray2;

    }

}
