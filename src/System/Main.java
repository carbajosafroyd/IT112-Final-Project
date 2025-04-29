/*
1.
- Choose your user type
- Redirect to login process
*/
package System;

import java.util.InputMismatchException;
import java.util.Scanner; 
public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        ReservationSystem reservationSystem = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
        try {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                 * Welcome to the Classroom Reservation System *                  ");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("   1. Admin                                                                       ");
            System.out.println("   2. Instructor                                                                  ");
            System.out.println("   3. Class Mayor                                                                 ");
            System.out.println("   4. Exit                                                                        ");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.print("Select user type: ");

            int choice = scanner.nextInt(); // Attempt to read an integer input

            switch (choice) {
                case 1: 
                    userManager.adminLogin(scanner, reservationSystem, userManager);
                    break;
                case 2:
                    userManager.instructorLogin(scanner, reservationSystem);
                    break;
                case 3:
                    userManager.mayorLogin(scanner, reservationSystem);
                    break;
                case 4:
                    System.out.println("\n\n");
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("                     -  Exiting the system. Goodbye!  -                           ");
                    System.out.println("----------------------------------------------------------------------------------");
                    return;
                
                default: 
                    System.out.println("\n\n");
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("                              Invalid choice.                                     ");
                    System.out.println("                             Please input 1-4 only.                              ");
                    System.out.println("----------------------------------------------------------------------------------");
                
            }
        } catch (InputMismatchException e) {
            
                    System.out.println("\n\n");
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("                              Invalid input.                                      ");
                    System.out.println("                      Please input a number between 1 and 4 only.                ");
                    System.out.println("----------------------------------------------------------------------------------");
                    scanner.nextLine(); 
        
    }
   System.out.println("\n\n");
}
}}
