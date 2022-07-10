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

import estgconstroi.exceptions.ConstructionSiteManagerException;
import java.util.Scanner;

/**
 * Class with all the arguments for the Main menu.
 *
 */
public class PrincipalMenu {

    private final ConstructionSiteManagerClass Constructions = new ConstructionSiteManagerClass();
    private final TeamManagerClass Teams = new TeamManagerClass();
    private final EquipmentsClass ListOfEquipments = new EquipmentsClass();
    private final EmployeeManagerClass Employees = new EmployeeManagerClass();
    private final EventManagerCass Events = new EventManagerCass();

    /**
     * Main Menu of the program.
     *
     * @throws ConstructionSiteManagerException
     */
    public void PrincipalMenu() throws ConstructionSiteManagerException {
        try {
            Scanner Read = new Scanner(System.in);
            int choice;
            do {
                System.out.println("========== MENU PRINCIPAL ==========");
                System.out.println("1 - MENU DE CONSTRUÇÕES");
                System.out.println("2 - MENU DE EVENTOS");
                System.out.println("3 - MENU DE TEAMS");
                System.out.println("4 - MENU DE FUNCIONÁRIOS");
                System.out.println("5 - MENU DE EQUIPAMENTOS");
                System.out.println("0 - SAIR");
                System.out.println("====================================");
                System.out.println("Escolha: ");
                choice = Read.nextInt();
            } while (choice < 0 || choice > 5);
            switch (choice) {
                case 0:
                    break;
                case 1:
                    ConstructionSiteMenu ConstructionMenu = new ConstructionSiteMenu();
                    ConstructionMenu.principalMenu(Constructions, Employees, Teams, ListOfEquipments);
                    PrincipalMenu();
                    break;
                case 2:
                    EventMenu EventMenu = new EventMenu();
                    EventMenu.principalMenu(Employees, Constructions, ListOfEquipments);
                    PrincipalMenu();
                    break;
                case 3:
                    TeamMenu teamMenu = new TeamMenu();
                    teamMenu.principalMenu(Teams);
                    PrincipalMenu();
                    break;
                case 4:
                    EmployeeMenu employeeMenu = new EmployeeMenu();
                    employeeMenu.principalMenu(Employees);
                    PrincipalMenu();
                    break;
                case 5:
                    EquipmentMenu menu = new EquipmentMenu();
                    menu.EquipmentsMenu(ListOfEquipments);
                    PrincipalMenu();
                    break;

            }
        } catch (Exception o) {
            System.out.println(o.getMessage());
            PrincipalMenu();

        }

    }

}
