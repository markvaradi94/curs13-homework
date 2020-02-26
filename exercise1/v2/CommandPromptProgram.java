package ro.fasttrackit.curs13.homework.exercise1.v2;

import ro.fasttrackit.curs13.homework.exercise1.v1.DaysOfTheWeek;

import java.util.Scanner;

public class CommandPromptProgram {

    public void getCommands(SchedulePlanner schedulePlanner) {
        Scanner scanner = new Scanner(System.in);
        boolean finished = false;
        int option;
        while (!finished) {
            printOptions();
            System.out.print("Option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    schedulePlanner.addActivityForTheDay(getDay(), getActivity());
                    System.out.println();
                    break;

                case 2:
                    schedulePlanner.removeActivity(getDay(), getActivity());
                    System.out.println();
                    break;

                case 3:
                    System.out.println(schedulePlanner.getActivities(getDay()) + "\n");
                    break;

                case 4:
                    System.out.println("Planning ended. The following plans have been made for the specified days: ");
                    System.out.println(schedulePlanner.endPlanning());
                    finished = true;
                    break;

                default:
                    System.out.println("Invalid option selected. Please select a different option\n");
                    break;
            }
        }
    }

    private DaysOfTheWeek getDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Day: ");
        String dayString = scanner.next().toUpperCase();
        return DaysOfTheWeek.valueOf(dayString);
    }

    private String getActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Activity: ");
        return scanner.next();
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
