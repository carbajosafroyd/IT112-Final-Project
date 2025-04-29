/* v
2.
- User Login
- Redirect to respective classes/menu

*/
package System;

import java.util.ArrayList;
import java.util.Scanner;
public class UserManager {
public final ArrayList<User> instructors = new ArrayList<>();
    private final ArrayList<User> mayors = new ArrayList<>();
    private final String adminUsername = "admin";
    private final String adminPassword = "admin123";

    public UserManager() {
        preloadUsers();
    }

    private void preloadUsers() {
        // Add preloaded instructor accounts
            instructors.add(new User("froyd123", "carbajosa", "Instructor"));
            instructors.add(new User("kyle123", "gotera", "Instructor"));
            instructors.add(new User("lie123", "tumagan", "Instructor"));
            instructors.add(new User("kimbie123", "batilong", "Instructor"));
            instructors.add(new User("fel123", "golosino", "Instructor"));

        // Add preloaded mayor accounts
            mayors.add(new User("bryl123", "pagalan", "Mayor"));
            mayors.add(new User("iris123", "pagalan", "Mayor"));
    }

    public void adminLogin(Scanner scanner, ReservationSystem reservationSystem, UserManager userManager) {
        System.out.println("\n\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("|                              * Hello, Admin! *                                 |");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.print("Enter admin username: ");
        String username = scanner.next();
        System.out.print("Enter admin password: ");
          String password = scanner.next();

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            AdminMenu.displayMenu(scanner, reservationSystem, userManager);
        } else {
            System.out.println("\n\n");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                         Invalid admin credentials.                               ");
            System.out.println("                          Returning to main menu...                               ");
            System.out.println("----------------------------------------------------------------------------------");
        }
    }

    public void instructorLogin(Scanner scanner, ReservationSystem reservationSystem) {
        System.out.println("\n\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("|                            * Hello, Instructor! *                               |");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        for (User user : instructors) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                InstructorMenu.displayMenu(scanner, reservationSystem);
                return;
            }
        }
        System.out.println("\n\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                          Invalid instructor credentials.                         ");
        System.out.println("                              Returning to main menu...                           ");
        System.out.println("----------------------------------------------------------------------------------");
    }

    public void mayorLogin(Scanner scanner, ReservationSystem reservationSystem) {
        System.out.println("\n\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("|                              * Hello, Mayor! *                                 |");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        for (User user : mayors) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                MayorMenu.displayMenu(scanner, reservationSystem);
                return;
            }
        }
        System.out.println("\n\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                          Invalid mayor credentials.                              ");
        System.out.println("                           Returning to main menu...                              ");
        System.out.println("----------------------------------------------------------------------------------");
    }    
}