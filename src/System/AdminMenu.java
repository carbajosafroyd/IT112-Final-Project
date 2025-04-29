/*
5.
- Admin's menu and functions


*/
package System;

import java.util.Scanner;

public class AdminMenu {
    public static void displayMenu(Scanner scanner, ReservationSystem reservationSystem, UserManager userManager) {
        while (true) {
            System.out.println("\n\n");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("|                                  Admin Menu                                    |");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("   1. Add User Account");
            System.out.println("   2. Add Classroom");
            System.out.println("   3. Add Schedule");
            System.out.println("   4. View Reserved Classrooms");
            System.out.println("   5. View Available Classrooms");
            System.out.println("   6. Cancel Schedule");
            System.out.println("   7. Remove User Account");
            System.out.println("   8. Remove Classroom");
            System.out.println("   9. Remove Schedule");
            System.out.println("   10. Logout");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addUserAccount(scanner, userManager, reservationSystem);
                    break;
                case 2: 
                    addClassroom(scanner, reservationSystem);
                    break;
                case 3:
                    addSchedule(scanner, reservationSystem);
                    break;
                case 4: 
                    viewReservedClassrooms(reservationSystem);
                    break;
                case 5:
                    viewAvailableClassrooms(reservationSystem);
                    break;
                case 6: 
                    cancelSchedule(scanner, reservationSystem);
                    break;
                case 7: 
                    removeUserAccount(scanner, userManager);
                    break;
                case 8: 
                    removeClassroom(scanner, reservationSystem);
                    break;
                case 9: 
                    removeSchedule(scanner, reservationSystem);
                    break;
                case 10:
                    System.out.println("\n\n");
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("                                Logging out...                                    ");
                    System.out.println("----------------------------------------------------------------------------------");
                    return;
                
                default: 
                    System.out.println("\n\n");
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("                        Invalid choice. Please try again.                         ");
                    System.out.println("----------------------------------------------------------------------------------");
                
            }
        }
    }

// 1. Add User Account
    private static void addUserAccount(Scanner scanner, UserManager userManager, ReservationSystem reservationSystem) {
        System.out.println("\n\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Creating an account...                                                            ");
        System.out.println("----------------------------------------------------------------------------------");
        
        System.out.print("Enter username: ");
        String username = scanner.next();
        
        System.out.print("Enter password: ");
        String password = scanner.next();
        
        System.out.print("Enter Your Name: ");
        String name = scanner.next();
        
        System.out.print("Enter role(Instructor/Mayor): ");
        String role = scanner.next();
        
        switch (role) {
            case "Instructor":
                System.out.println("\n");
                System.out.println("----------------------------------------------------------------------------------");
                userManager.instructors.add(new User (username,password,role));
                reservationSystem.instructors.add((name));
                System.out.println("                   Instructor account added successfully.                         ");
                System.out.println("----------------------------------------------------------------------------------");
                break;
            case "Mayor":
                System.out.println("\n");
                System.out.println("----------------------------------------------------------------------------------");
                userManager.instructors.add(new User (username,password,role));
                System.out.println("                      Mayor account added successfully.                           ");
                System.out.println("----------------------------------------------------------------------------------");
                break;
            default:
                System.out.println("\n");
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("                                Invalid choice.                                   ");
                System.out.println("----------------------------------------------------------------------------------");
                break;
        }
    }

// 2. Add Classroom
    private static void addClassroom(Scanner scanner, ReservationSystem reservationSystem) {
        System.out.println("\n\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Adding new Classroom...                                                           ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.print("Enter classroom name: ");
        String name = scanner.next();
        if (reservationSystem.classrooms.contains(name)) {
            System.out.println("\n----------------------------------------------------------------------------------");
            System.out.println("                           Classroom already exists.                              ");
            System.out.println("----------------------------------------------------------------------------------");
        } else {
            reservationSystem.classrooms.add(name);
            System.out.println("\n----------------------------------------------------------------------------------");
            System.out.println("                          Classroom added successfully.                           ");
            System.out.println("----------------------------------------------------------------------------------");
        }
    }

// 3. Add Schedule
    private static void addSchedule(Scanner scanner, ReservationSystem reservationSystem) {
        System.out.println("\n\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Adding new Schedule...                                                            ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Which Classrooms?:");
        for (int i = 0; i < reservationSystem.classrooms.size(); i++) {
            System.out.println((i + 1) + ". " + reservationSystem.classrooms.get(i));
        }
        System.out.println("----------------------------------------------------------------------------------");
        System.out.print("Select classroom: ");
        int classroomIndex = scanner.nextInt() - 1;
        
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Days:");
        for (int i = 0; i < ReservationSystem.days.length; i++) {
            System.out.println((i + 1) + ". " + ReservationSystem.days[i]);
        }
        
        System.out.println("----------------------------------------------------------------------------------");
        System.out.print("Select day: ");
        int dayIndex = scanner.nextInt() - 1;
        System.out.println("----------------------------------------------------------------------------------");

        
        System.out.println("Time Slots:");
        for (int i = 0; i < ReservationSystem.timeslots.length; i++) {
            System.out.println((i + 1) + ". " + ReservationSystem.timeslots[i]);
        
        }
        
        System.out.println("----------------------------------------------------------------------------------");
        System.out.print("Select timeslot: ");
        int timeSlotIndex = scanner.nextInt() - 1;
        System.out.println("----------------------------------------------------------------------------------");

        if (reservationSystem.schedules[dayIndex][timeSlotIndex][classroomIndex] == null) {
            reservationSystem.schedules[dayIndex][timeSlotIndex][classroomIndex] = "Available (Added by Admin)";
            System.out.println("\n----------------------------------------------------------------------------------");
            System.out.println("                           Schedule added successfully.                           ");
            System.out.println("----------------------------------------------------------------------------------");
        } else {
            System.out.println("\n----------------------------------------------------------------------------------");
            System.out.println("                      Time slot is already occupied/reserved.                       ");
            System.out.println("----------------------------------------------------------------------------------");
        }
    }

// 4. View Reserved Classrooms
    private static void viewReservedClassrooms(ReservationSystem reservationSystem) {
        System.out.println("\n\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("|                -  All Reserved, Occupied, and Added Schedule  -                      |");
        System.out.println("----------------------------------------------------------------------------------");
        for (int day = 0; day < reservationSystem.schedules.length; day++) {
            for (int slot = 0; slot < reservationSystem.schedules[day].length; slot++) {
                for (int room = 0; room < reservationSystem.schedules[day][slot].length; room++) {
                    String schedule = reservationSystem.schedules[day][slot][room];
                    if (schedule != null) {
                        System.out.println(ReservationSystem.days[day] + "    " + ReservationSystem.timeslots[slot] + "    " + "-" + "    " + reservationSystem.classrooms.get(room) + "    :    " + schedule);
                    }                    
                }
            } System.out.println("----------------------------------------------------------------------------------");
        } 
    }

// 5. View Available Classrooms

    private static void viewAvailableClassrooms(ReservationSystem reservationSystem) {
    System.out.println("\n\n");
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("                          -  Available Classrooms  -                              ");
    System.out.println("----------------------------------------------------------------------------------");

    try {
        for (int day = 0; day < reservationSystem.schedules.length; day++) {
            System.out.println(ReservationSystem.days[day] + ":");
            
            for (int slot = 0; slot < reservationSystem.schedules[day].length; slot++) {
                System.out.println("    " + ReservationSystem.timeslots[slot] + ":");

                for (int room = 0; room < reservationSystem.classrooms.size(); room++) {
                    String schedule = reservationSystem.schedules[day][slot][room];

                    if (schedule == null) {
                        // Display available slots
                        System.out.println("        " + reservationSystem.classrooms.get(room) + ": Available");
                    }
                }
            }
            System.out.println("----------------------------------------------------------------------------------");
        }
    } catch (IndexOutOfBoundsException e) {
        // Catch the exception and print an error message for debugging
        System.out.println("Error: Classroom index out of bounds. Please check classroom data.");
    }
}

// 6. Cancel Schedule
    private static void cancelSchedule(Scanner scanner, ReservationSystem reservationSystem) {
    System.out.println("\n");
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("                             Canceling a schedule...                              ");
    System.out.println("----------------------------------------------------------------------------------");

    // Display all schedules
    viewReservedClassrooms(reservationSystem);

    // Input classroom
    System.out.print("Enter the classroom name: ");
    String classroomName = scanner.next();
    int classroomIndex = reservationSystem.classrooms.indexOf(classroomName);
    
    if (classroomIndex == -1) {
        System.out.println("\n\n");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                            Invalid classroom name.                               ");
            System.out.println("                            Returning to main menu...                             ");
            System.out.println("----------------------------------------------------------------------------------");
        return;
    }

    // Input day  
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("Days:");
    for (int i = 0; i < ReservationSystem.days.length; i++) {
        System.out.println((i + 1) + ". " + ReservationSystem.days[i]);
    }
    System.out.println("----------------------------------------------------------------------------------");
    System.out.print("Select day: ");
    int dayIndex = scanner.nextInt() - 1;

    // Input timeslot
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("Timeslots:");
    for (int i = 0; i < ReservationSystem.timeslots.length; i++) {
        System.out.println((i + 1) + ". " + ReservationSystem.timeslots[i]);
    }
    System.out.println("----------------------------------------------------------------------------------");
    System.out.print("Select timeslot: ");
    int timeSlotIndex = scanner.nextInt() - 1;

    if (dayIndex >= 0 && dayIndex < ReservationSystem.days.length &&
        timeSlotIndex >= 0 && timeSlotIndex < ReservationSystem.timeslots.length) {

        if (reservationSystem.schedules[dayIndex][timeSlotIndex][classroomIndex] != null) {
            reservationSystem.schedules[dayIndex][timeSlotIndex][classroomIndex] = null;
            System.out.println("\n\n");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                       Schedule canceled successfully.                            ");
            System.out.println("----------------------------------------------------------------------------------");
        } else {
            System.out.println("\n\n");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("            No schedule found for the selected day, time, and classroom           ");
            System.out.println("----------------------------------------------------------------------------------");
     
        }
    } else {
        System.out.println("\n\n");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                              Invalid selection.                                  ");
            System.out.println("----------------------------------------------------------------------------------");

    }
}

// 7. Remove User Account
    private static void removeUserAccount(Scanner scanner, UserManager userManager){ 
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                             Removing an account...                              ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        System.out.print("Enter role(Instructor/Mayor): ");
        String role = scanner.next();
        
        switch (role) {
            case "Instructor":
                userManager.instructors.remove(new User (username,password,role));
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("                   Instructor account removed successfully.                       ");
                System.out.println("----------------------------------------------------------------------------------");
                break;
            case "Mayor":
                userManager.instructors.remove(new User (username,password,role));
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("                     Mayor account removed successfully.                          ");
                System.out.println("----------------------------------------------------------------------------------");
                break;
            default:
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("                               Invalid Role.                                      ");
                System.out.println("----------------------------------------------------------------------------------");
                break;
        }
    }

// 8. Remove Classroom
    private static void removeClassroom(Scanner scanner, ReservationSystem reservationSystem) {
        System.out.println("\n\n");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                               Removing Classroom                                 ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("\nClassrooms lists:");
        for (int i = 0; i < reservationSystem.classrooms.size(); i++) {
            System.out.println((i + 1) + ". " + reservationSystem.classrooms.get(i));
        } System.out.println("----------------------------------------------------------------------------------");
        System.out.print("Enter classroom number to remove: ");
        int classroomIndex = scanner.nextInt() - 1;

        if (classroomIndex >= 0 && classroomIndex < reservationSystem.classrooms.size()) {
            reservationSystem.classrooms.remove(classroomIndex);
            System.out.println("\n----------------------------------------------------------------------------------");
            System.out.println("                       Classroom removed successfully.                            ");
            System.out.println("----------------------------------------------------------------------------------");
        } else {
            System.out.println("\n---------------------------------------------------------------------------------");
            System.out.println("                               Invalid selection.                                 ");
            System.out.println("----------------------------------------------------------------------------------");
        }
    }

// 9. Remove Schedule
    private static void removeSchedule(Scanner scanner, ReservationSystem reservationSystem) {
    System.out.println("\n");
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("                             Removing a schedule...                               ");
    System.out.println("----------------------------------------------------------------------------------");

    // Display all schedules
    viewReservedClassrooms(reservationSystem);

    // Input classroom
    System.out.print("Enter the classroom name: ");
    String classroomName = scanner.next();
    int classroomIndex = reservationSystem.classrooms.indexOf(classroomName);

    if (classroomIndex == -1) {
        System.out.println("Invalid classroom name. Returning to menu.");
        return;
    }

    // Input day
    System.out.println("Days:");
    for (int i = 0; i < ReservationSystem.days.length; i++) {
        System.out.println((i + 1) + ". " + ReservationSystem.days[i]);
    }
    System.out.print("Select day: ");
    int dayIndex = scanner.nextInt() - 1;

    // Input timeslot
    System.out.println("Timeslots:");
    for (int i = 0; i < ReservationSystem.timeslots.length; i++) {
        System.out.println((i + 1) + ". " + ReservationSystem.timeslots[i]);
    }
    System.out.print("Select timeslot: ");
    int timeSlotIndex = scanner.nextInt() - 1;

    if (dayIndex >= 0 && dayIndex < ReservationSystem.days.length &&
        timeSlotIndex >= 0 && timeSlotIndex < ReservationSystem.timeslots.length) {

        if (reservationSystem.schedules[dayIndex][timeSlotIndex][classroomIndex] != null) {
            reservationSystem.schedules[dayIndex][timeSlotIndex][classroomIndex] = null;
            System.out.println("Schedule removed permanently.");
        } else {
            System.out.println("No schedule found for the selected day, time, and classroom.");
        }
    } else {
        System.out.println("Invalid selection.");
    }
}
}
