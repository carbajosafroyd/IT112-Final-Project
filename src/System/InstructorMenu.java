/*
6.
- Instructor's menu and functions

*/
package System;

import java.util.Scanner;

public class InstructorMenu {
    public static void displayMenu(Scanner scanner, ReservationSystem reservationSystem) {
        System.out.print("Enter your name: ");
        String name = scanner.next();
        int instructorIndex = findInstructorIndex(name, reservationSystem);
        if (instructorIndex == -1) {
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
            System.out.println("|                                Instructor Menu                                 |");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("    1. View Your Schedule");
            System.out.println("    2. View All Schedules");
            System.out.println("    3. Reserve a Classroom");
            System.out.println("    4. Cancel a Schedule");
            System.out.println("    5. Logout");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewInstructorSchedule(instructorIndex, reservationSystem);
                    break;
                case 2:
                    viewAllSchedules(reservationSystem);
                    break;
                case 3:
                    reserveClassroom(scanner, instructorIndex, reservationSystem, name);
                    break;
                case 4:
                    cancelSchedule(scanner, instructorIndex, reservationSystem);
                    break;
                case 5:
                    System.out.println("\n\n");
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("                                  Logging out...                                  ");
                    System.out.println("----------------------------------------------------------------------------------");
                    return;
                
                default:
                    System.out.println("\n\n");
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("                                 Invalid choice.                                  ");
                    System.out.println("                                Please try again...                               ");
                    System.out.println("----------------------------------------------------------------------------------");
                
            }
        }
    }

    // Find the instructor index based on the username
    private static int findInstructorIndex(String name, ReservationSystem reservationSystem) {
        for (int i = 0; i < reservationSystem.instructors.size(); i++) {
            if (reservationSystem.instructors.get(i).equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    // 1. View Instructor's Schedule
    private static void viewInstructorSchedule(int instructorIndex, ReservationSystem reservationSystem) {
    String instructor = reservationSystem.instructors.get(instructorIndex);
    System.out.println("\n\n");
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("|                             Schedule for " + instructor + ":                                 |");
    System.out.println("----------------------------------------------------------------------------------");

    for (int day = 0; day < reservationSystem.schedules.length; day++) {
        System.out.println(reservationSystem.days[day] + ":");
        for (int slot = 0; slot < reservationSystem.schedules[day].length; slot++) {
            for (int room = 0; room < reservationSystem.schedules[day][slot].length; room++) {
                if (instructor.equals(reservationSystem.schedules[day][slot][room])) {
                    System.out.println("   " + reservationSystem.timeslots[slot] + "   -   " + reservationSystem.classrooms.get(room));
                }
            }
        }
    } System.out.println("----------------------------------------------------------------------------------");
}

    // 2. View All Schedules
    public static void viewAllSchedules(ReservationSystem reservationSystem) {
     System.out.println("\n\n");
     System.out.println("----------------------------------------------------------------------------------");
     System.out.println("                 -  All Schedule (Occupied and Available)  -                      ");
     System.out.println("----------------------------------------------------------------------------------");
     System.out.println("Available Classrooms:");
     
    for (int day = 0; day < ReservationSystem.days.length; day++) {
        System.out.println( ReservationSystem.days[day] + ":");

        for (int slot = 0; slot < ReservationSystem.timeslots.length; slot++) {
            System.out.println("    " + ReservationSystem.timeslots[slot] + ":");

            for (int room = 0; room < reservationSystem.classrooms.size(); room++) {
                String schedule = reservationSystem.schedules[day][slot][room];
                if (schedule == null) {
                    // Display available slots
                    System.out.println("        " + reservationSystem.classrooms.get(room) + ": Available");
                } else {
                    // Display occupied slots
                    System.out.println("        " + reservationSystem.classrooms.get(room) + ": " + schedule);
                }
            }
        }  System.out.println("----------------------------------------------------------------------------------");
    }
}



    // 3. Reserve a Classroom
    public static void reserveClassroom(Scanner scanner, int instructorIndex, ReservationSystem reservationSystem, String name) {
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
        // Reserve the slot for the instructor
        reservationSystem.schedules[dayIndex][timeSlotIndex][classroomIndex] = 
                "Reserved by " + "Instructor " + name;
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


    // 4. Cancel a Schedule
    private static void cancelSchedule(Scanner scanner, int instructorIndex, ReservationSystem reservationSystem) {
    String instructor = reservationSystem.instructors.get(instructorIndex);
    System.out.println("\n\n");
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("|                           -  Cancel Schedule  -                                |");
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("Cancel a schedule from your list:");
    viewInstructorSchedule(instructorIndex, reservationSystem);

    System.out.println("Days:");
    for (int i = 0; i < ReservationSystem.days.length; i++) {
        System.out.println("    "+(i + 1) + ". " + ReservationSystem.days[i]);
    }
    
    System.out.println("----------------------------------------------------------------------------------");
    System.out.print("Select day: ");
    int dayIndex = scanner.nextInt() - 1;
    System.out.println("----------------------------------------------------------------------------------");

    System.out.println("Timeslots:");
    for (int i = 0; i < ReservationSystem.timeslots.length; i++) {
        System.out.println("    "+(i + 1) + ". " + ReservationSystem.timeslots[i]);
    }
    
    System.out.println("----------------------------------------------------------------------------------");
    System.out.print("Select timeslot: ");
    int timeSlotIndex = scanner.nextInt() - 1;

    for (int room = 0; room < reservationSystem.classrooms.size(); room++) {
        if (instructor.equals(reservationSystem.schedules[dayIndex][timeSlotIndex][room])) {
            reservationSystem.schedules[dayIndex][timeSlotIndex][room] = null;
            System.out.println("\n\n");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                       Schedule canceled successfully.                            ");
            System.out.println("----------------------------------------------------------------------------------");
            return;
        }
    }
    System.out.println("\n\n");
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("                   No matching schedule found to cancel.                          ");
    System.out.println("----------------------------------------------------------------------------------");
}
}