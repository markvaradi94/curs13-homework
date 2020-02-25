package ro.fasttrackit.curs13.homework.exercise1;

public class NoActivitiesForDayException extends Exception {
    private final DaysOfTheWeek dayOfTheWeek;

    public NoActivitiesForDayException(DaysOfTheWeek dayOfTheWeek) {
        super("No activities for " + dayOfTheWeek);
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public DaysOfTheWeek getDayOfTheWeek() {
        return this.dayOfTheWeek;
    }
}
