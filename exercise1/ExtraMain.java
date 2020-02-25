package ro.fasttrackit.curs13.homework.exercise1;

public class ExtraMain {
    public static void main(String[] args) {
        DailyPlanner planner = new DailyPlanner();
        CommandProgram program = new CommandProgram();
        program.getCommands(planner);
    }

}
