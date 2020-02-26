package ro.fasttrackit.curs13.homework.exercise1.v2;

import ro.fasttrackit.curs13.homework.exercise1.exceptions.NoActivitiesForDayException;

import static ro.fasttrackit.curs13.homework.exercise1.v1.DaysOfTheWeek.*;

public class Main {
    public static void main(String[] args) {
        SchedulePlanner schedulePlanner = new SchedulePlanner();
        schedulePlanner.addActivityForTheDay(MONDAY, "Rowing");
        schedulePlanner.addActivityForTheDay(MONDAY, "painting");
        System.out.println(schedulePlanner.getSchedules());
        printSeparator();
        schedulePlanner.addActivityForTheDay(TUESDAY, "walking");
        schedulePlanner.addActivityForTheDay(TUESDAY, "Reading");
        schedulePlanner.addActivityForTheDay(WEDNESDAY, "cooking");
        schedulePlanner.addActivityForTheDay(TUESDAY, "cleaning");
        schedulePlanner.addActivityForTheDay(MONDAY, "running");
        schedulePlanner.addActivityForTheDay(FRIDAY, "hiking");
        schedulePlanner.addActivityForTheDay(SATURDAY, "sleeping");
        schedulePlanner.addActivityForTheDay(SUNDAY, "singing");
        System.out.println(schedulePlanner.getSchedules());
        printSeparator();
        schedulePlanner.removeActivity(MONDAY, "running");
        System.out.println(schedulePlanner.getSchedules());
        printSeparator();
//        schedulePlanner.removeActivity(TUESDAY, "painting");
//        schedulePlanner.removeActivity(THURSDAY, "Eating");
//        schedulePlanner.addActivityForTheDay(MONDAY, null);
//        schedulePlanner.addActivityForTheDay(MONDAY, "");
        System.out.println(schedulePlanner.endPlanning());
        printSeparator();
        try {
            schedulePlanner.checkDailySchedules();
        } catch (NoActivitiesForDayException nafde) {
            System.err.println(nafde.getMessage());
        }

        System.out.println();
        CommandPromptProgram program = new CommandPromptProgram();
        SchedulePlanner planner = new SchedulePlanner();
        program.getCommands(planner);
    }

    public static void printSeparator() {
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
