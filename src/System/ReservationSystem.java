/*
4.
- classroom and schedule 
- preload users' accounts

*/
package System;

import java.util.ArrayList;

public final class ReservationSystem {
    public final ArrayList<String> classrooms = new ArrayList<>();
    public final String[][][] schedules = new String[5][6][5]; // [days][timeslots][classrooms]
    public final ArrayList<String> instructors = new ArrayList<>();
    public final ArrayList<String> mayors = new ArrayList<>();

    public static final String[] days = {
        "Monday   ", 
        "Tuesday  ",
        "Wednesday",
        "Thursday ",
        "Friday   "};
    public static final String[] timeslots = {
        "7:00am - 8:30am   ",
        "8:30am - 10:00am  ", 
        "10:00am - 11:30pm ",
        "1:00pm - 2:30pm   ", 
        "2:30pm - 4:00pm   ", 
        "4:00pm - 5:30pm   "
    };
    public static final String[] room = {"AB1-1", "AB1-2", "AB1-3", "AB1-4",};
    
    public ReservationSystem() {
        preloadClassrooms();
        preloadInstructors();
        preloadStaticSchedule();
        preloadMayors ();
    }

    private void preloadClassrooms() {
        classrooms.add("AB1-1");
        classrooms.add("AB1-2");
        classrooms.add("AB1-3");
        classrooms.add("AB1-4");
    }

    public void preloadInstructors() {
        instructors.add("froyd"); //Instructor1
        instructors.add("kyle");  //Instructor2
        instructors.add("lie");   //Instructor3  
        instructors.add("kimbie");//Instructor4
        instructors.add("fel");   //Instructor5
    }
    
    public void preloadMayors () {
        mayors.add("bryl");
        mayors.add("iris");
    }

    private void preloadStaticSchedule() {
        
        // [days][timeslots][classrooms]
        
        // Monday Schedule
        // 7:00am - 8:30am
        schedules[0][0][0] = null; //availabale;
        schedules[0][0][1] = "lie"; 
        schedules[0][0][2] = "kyle"; 
        schedules[0][0][3] = "fel";
        // 8:30am-10:00am
        schedules[0][1][0] = "froyd"; 
        schedules[0][1][1] = "kyle";
        schedules[0][1][2] = "lie"; 
        schedules[0][1][3] = "kimbie";
        // 10:00am - 11:30pm
        schedules[0][2][0] = "kyle"; 
        schedules[0][2][1] = "froyd";
        schedules[0][2][2] = "kimbie"; 
        schedules[0][2][3] = "fel";
        // 1:00pm - 2:30pm
        schedules[0][3][0] = "lie"; 
        schedules[0][3][1] = "kimbie";
        schedules[0][3][2] = null; //availabale 
        schedules[0][3][3] = null; //availabale
        // 2:30pm - 4:00pm
        schedules[0][4][0] = "kyle"; 
        schedules[0][4][1] = "kimbie";
        schedules[0][4][2] = null; //availabale 
        schedules[0][4][3] = null; //availabale
        // 4:00pm - 5:30pm
        schedules[0][5][0] = "kimbie"; 
        schedules[0][5][1] = "fel";
        schedules[0][5][2] = null; //availabale 
        schedules[0][5][3] = "froyd";
        
        
        //Tuesday Schedule
        // 7:00am - 8:30am
        schedules[1][0][0] = "froyd";
        schedules[1][0][1] = "lie"; 
        schedules[1][0][2] = "kimbie"; 
        schedules[1][0][3] = null; //availabale
        // 8:30am-10:00am 
        schedules[1][1][0] = "kyle";
        schedules[1][1][1] = null; //availabale
        schedules[1][1][2] = "lie"; 
        schedules[1][1][3] = "kimbie";
        // 10:00am - 11:30pm
        schedules[1][2][0] = "kimbie"; 
        schedules[1][2][1] = "froyd";
        schedules[1][2][2] = "kyle"; 
        schedules[1][2][3] = "lie";
        // 1:00pm - 2:30pm
        schedules[1][3][0] = "fel"; 
        schedules[1][3][1] = null; //availabale
        schedules[1][3][2] = null; //availabale
        schedules[1][3][3] = null; //availabale
        // 2:30pm - 4:00pm
        schedules[1][4][0] = "froyd"; 
        schedules[1][4][1] = "kimbie";
        schedules[1][4][2] = "lie";
        schedules[1][4][3] = "kyle"; 
        // 4:00pm - 5:30pm
        schedules[1][5][0] = null; //availabale  
        schedules[1][5][1] = "fel";
        schedules[1][5][2] = "kyle"; 
        schedules[1][5][3] = "froyd";
        
        // Wednesday Schedule
        // 7:00am - 8:30am
        schedules[2][0][0] = "froyd";
        schedules[2][0][1] = "lie";
        schedules[2][0][2] = "fel";
        schedules[2][0][3] = null; //available
        // 8:30am-10:00am
        schedules[2][1][0] = "fel";
        schedules[2][1][1] = null; //available
        schedules[2][1][2] = "froyd";
        schedules[2][1][3] = "kimbie";
        // 10:00am - 11:30pm
        schedules[2][2][0] = "kimbie";
        schedules[2][2][1] = "kyle";
        schedules[2][2][2] = "lie";
        schedules[2][2][3] = "froyd";
        // 1:00pm - 2:30pm
        schedules[2][3][0] = null; //available
        schedules[2][3][1] = "froyd";
        schedules[2][3][2] = "kyle";
        schedules[2][3][3] = "fel";
        // 2:30pm - 4:00pm
        schedules[2][4][0] = "kyle";
        schedules[2][4][1] = "fel";
        schedules[2][4][2] = "kimbie";
        schedules[2][4][3] = "kyle";
        // 4:00pm - 5:30pm
        schedules[2][5][0] = "lie";
        schedules[2][5][1] = "kimbie";
        schedules[2][5][2] = null; //available
        schedules[2][5][3] = "kyle";

        
        // Thursday Schedule
        // 7:00am - 8:30am
        schedules[3][0][0] = null; //availabale;
        schedules[3][0][1] = "lie"; 
        schedules[3][0][2] = "kyle"; 
        schedules[3][0][3] = "fel";
        // 8:30am-10:00am
        schedules[3][1][0] = "froyd"; 
        schedules[3][1][1] = "kyle";
        schedules[3][1][2] = "lie"; 
        schedules[3][1][3] = "kimbie";
        // 10:00am - 11:30pm
        schedules[3][2][0] = "kyle"; 
        schedules[3][2][1] = "froyd";
        schedules[3][2][2] = "kimbie"; 
        schedules[3][2][3] = "fel";
        // 1:00pm - 2:30pm
        schedules[3][3][0] = "lie"; 
        schedules[3][3][1] = "kimbie";
        schedules[3][3][2] = null; //availabale 
        schedules[3][3][3] = null; //availabale
        // 2:30pm - 4:00pm
        schedules[3][4][0] = "kyle"; 
        schedules[3][4][1] = "kimbie";
        schedules[3][4][2] = null; //availabale 
        schedules[3][4][3] = null; //availabale
        // 4:00pm - 5:30pm
        schedules[3][5][0] = "kimbie"; 
        schedules[3][5][1] = "fel";
        schedules[3][5][2] = null; //availabale 
        schedules[3][5][3] = "froyd";
        
        //Friday Schedule
        // 7:00am - 8:30am
        schedules[4][0][0] = "froyd";
        schedules[4][0][1] = "lie"; 
        schedules[4][0][2] = "kimbie"; 
        schedules[4][0][3] = null; //availabale
        // 8:30am-10:00am 
        schedules[4][1][0] = "kyle";
        schedules[4][1][1] = null; //availabale
        schedules[4][1][2] = "lie"; 
        schedules[4][1][3] = "kimbie";
        // 10:00am - 11:30pm
        schedules[4][2][0] = "kimbie"; 
        schedules[4][2][1] = "froyd";
        schedules[4][2][2] = "kyle"; 
        schedules[4][2][3] = "lie";
        // 1:00pm - 2:30pm
        schedules[4][3][0] = "fel"; 
        schedules[4][3][1] = null; //availabale
        schedules[4][3][2] = null; //availabale
        schedules[4][3][3] = null; //availabale
        // 2:30pm - 4:00pm
        schedules[4][4][0] = "froyd"; 
        schedules[4][4][1] = "kimbie";
        schedules[4][4][2] = "lie";
        schedules[4][4][3] = "kyle"; 
        // 4:00pm - 5:30pm
        schedules[4][5][0] = null; //availabale  
        schedules[4][5][1] = "fel";
        schedules[4][5][2] = "kyle"; 
        schedules[4][5][3] = "froyd";
        
     
    }
}

