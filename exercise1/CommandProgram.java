package ro.fasttrackit.curs13.homework.exercise1;

import java.util.Scanner;

public class CommandProgram {

    public void getCommands(DailyPlanner planner) {
        Scanner scanner = new Scanner(System.in);
        boolean finished = false;
        printOptions();
        int option;
        while (!finished) {
            System.out.print("Option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Day: ");
                    String dayString = scanner.next().toUpperCase();
                    DaysOfTheWeek dayOfTheWeek = DaysOfTheWeek.valueOf(dayString);
                    System.out.print("Activity: ");
                    String activity = scanner.next();
                    planner.addActivity(dayOfTheWeek, activity);
                    System.out.println();
                    printOptions();
                    break;

                case 2:
                    System.out.print("Day: ");
                    dayString = scanner.next().toUpperCase();
                    dayOfTheWeek = DaysOfTheWeek.valueOf(dayString);
                    System.out.print("Activity: ");
                    activity = scanner.next();
                    planner.removeActivity(dayOfTheWeek, activity);
                    System.out.println();
                    printOptions();
                    break;

                case 3:
                    System.out.print("Day: ");
                    dayString = scanner.next().toUpperCase();
                    dayOfTheWeek = DaysOfTheWeek.valueOf(dayString);
                    System.out.println(planner.getActivities(dayOfTheWeek) + "\n");
                    printOptions();
                    break;

                case 4:
                    System.out.println("Planning ended. The following plans have been made for the specified days: ");
                    System.out.println(planner.endPlanning());
                    finished = true;
                    break;

                default:
                    System.out.println("Invalid option selected. Please select a different option\n");
                    printOptions();
                    break;
            }
        }
    }

    private void printOptions() {
        System.out.println("Press:");
        System.out.println("1 - To add an activity.");
        System.out.println("2 - To remove an activity.");
        System.out.println("3 - To list all activities for a specific day.");
        System.out.println("4 - To end planning activities.");
        System.out.println();
    }
}
