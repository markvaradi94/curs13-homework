package ro.fasttrackit.curs13.homework.exercise1;

import static ro.fasttrackit.curs13.homework.exercise1.DaysOfTheWeek.*;

public class Main {
    public static void main(String[] args) {
        DailyPlanner planner = new DailyPlanner();
        planner.addActivity(MONDAY, "Swimming");
        planner.addActivity(MONDAY, "Hiking");
        planner.addActivity(TUESDAY, "Eating");
        planner.addActivity(SATURDAY, "Dancing");
        planner.addActivity(SUNDAY, "Nothing");
        planner.addActivity(MONDAY, "Working");
        planner.addActivity(WEDNESDAY, "Reading");
        planner.addActivity(FRIDAY, "Relaxing");
        planner.addActivity(FRIDAY, "Cleaning");

        printLine();
        System.out.println(planner.getDailySchedules());
        planner.removeActivity(MONDAY, "Hiking");
        printLine();
        System.out.println(planner.getDailySchedules());
        planner.removeActivity(TUESDAY, "Eating");
        printLine();
        System.out.println(planner.getDailySchedules());

        try {
            planner.addActivity(THURSDAY, "");
        } catch (NoActivityException nae) {
            System.err.println(nae.getMessage());
        }
        try {
            planner.removeActivity(WEDNESDAY, "Eating");
        } catch (NoActivityException nae) {
            System.err.println(nae.getMessage());
        }

//        planner.removeActivity(MONDAY,"Hiking");
//        printLine();
//        System.out.println(planner.getDailySchedules());

        printLine();
        System.out.println(planner.endPlanning());
        printLine();

        try {
            planner.checkDailySchedules();
        } catch (NoActivitiesForDayException nafde) {
            System.err.println(nafde.getMessage());
        }

        System.out.println(planner.getActivities(MONDAY));
        printLine();
        System.out.println(planner.getActivities(FRIDAY));
    }

    public static void printLine() {
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
