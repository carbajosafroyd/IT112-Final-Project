/*
7.
- Mayor's menu and functions

*/
package System;

import java.util.Scanner;

public class MayorMenu {
    public static void displayMenu(Scanner scanner, ReservationSystem reservationSystem) {
        System.out.print("Enter your name: ");
        String name = scanner.next();
        int mayorIndex = findMayorIndex(name, reservationSystem);
        if (mayorIndex == -1) {
            System.out.println("\n\n");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                                Invalid name.                                     ");
            System.out.println("                           Returning to main menu...                              ");
            System.out.println("----------------------------------------------------------------------------------");
            return;
        }
        
        while (true) {
            System.out.println("\n\n");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("|                                Mayor Menu                                      |");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("    1. View All Schedules                                                         ");
            System.out.println("    2. Reserve a Classroom                                                        ");
            System.out.println("    3. Logout                                                                     ");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    InstructorMenu.viewAllSchedules(reservationSystem);
                    break;
                case 2: 
                    reserveClassroom(scanner, mayorIndex, reservationSystem, name);
                    break;
                case 3:
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("                                Logging out...                                    ");
                    System.out.println("----------------------------------------------------------------------------------");
                    return;
                
                default:
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("                               Invalid choice.                                    ");
                    System.out.println("                              Please try again.                                   ");
                    System.out.println("----------------------------------------------------------------------------------");
                
            }
            
        }
        
    }
    
    // findmayor index
    private static int findMayorIndex(String name, ReservationSystem reservationSystem) {
    for (int i = 0; i < reservationSystem.mayors.size(); i++) {
        if (reservationSystem.mayors.get(i).equalsIgnoreCase(name)) { 
            return i;
        }
    }
    return -1;
    }

    
    
    //2. reserve classroom for mayor
    public static void reserveClassroom(Scanner scanner, int mayorIndex, ReservationSystem reservationSystem, String name) {
    System.out.println("\n\n");
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("|                          -  Available Classroom  -                             |");
    System.out.println("----------------------------------------------------------------------------------");

    for (int i = 0; i < reservationSystem.classrooms.size(); i++) {
        System.out.println("    " + (i + 1) + ". " + reservationSystem.classrooms.get(i));
    }
    System.out.println("----------------------------------------------------------------------------------");
    System.out.print("Select a classroom: ");
    int classroomIndex = scanner.nextInt() - 1;
    

    if (classroomIndex < 0 || classroomIndex >= reservationSystem.classrooms.size()) {
        System.out.println("\n\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                             Invalid day selection.                               ");
        System.out.println("                               Returning to menu...                               ");
        System.out.println("----------------------------------------------------------------------------------");
        return;
    }
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("Days:");
    for (int i = 0; i < ReservationSystem.days.length; i++) {
        System.out.println("    " +(i + 1) + ". " + ReservationSystem.days[i]);
    }
    
    System.out.println("----------------------------------------------------------------------------------");
    System.out.print("Select day: ");
    int dayIndex = scanner.nextInt() - 1;
    System.out.println("----------------------------------------------------------------------------------");

    if (dayIndex < 0 || dayIndex >= ReservationSystem.days.length) {
        System.out.println("\n\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                             Invalid day selection.                               ");
        System.out.println("                               Returning to menu...                               ");
        System.out.println("----------------------------------------------------------------------------------");
        return;
    }

    System.out.println("Timeslots:");
    for (int i = 0; i < ReservationSystem.timeslots.length; i++) {
        System.out.println("    " +(i + 1) + ". " + ReservationSystem.timeslots[i]);
    }
    System.out.println("----------------------------------------------------------------------------------");
    System.out.print("Select timeslot: ");
    int timeSlotIndex = scanner.nextInt() - 1;
    System.out.println("----------------------------------------------------------------------------------");

    if (timeSlotIndex < 0 || timeSlotIndex >= ReservationSystem.timeslots.length) {
        System.out.println("\n\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                             Invalid day selection.                               ");
        System.out.println("                               Returning to menu...                               ");
        System.out.println("----------------------------------------------------------------------------------");
        return;
    }

    // Check if the slot is available
    if (reservationSystem.schedules[dayIndex][timeSlotIndex][classroomIndex] == null) {
        // Reserve the slot for the mayor
        reservationSystem.schedules[dayIndex][timeSlotIndex][classroomIndex] = 
                "Reserved by " + "Mayor " + name;
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                             Reservation successful."                              );
        System.out.println("----------------------------------------------------------------------------------");
    } else {
        // Slot is already occupied
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                           Timeslot is already reserved.                          ");
        System.out.println("                                 Try another slot.                                ");
        System.out.println("----------------------------------------------------------------------------------");
    }
}
}
 