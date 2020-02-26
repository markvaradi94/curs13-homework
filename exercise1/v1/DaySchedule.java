package ro.fasttrackit.curs13.homework.exercise1.v1;

import java.util.*;

public class DaySchedule {
    private DaysOfTheWeek dayOfTheWeek;
    private String activity;

    public DaySchedule(DaysOfTheWeek dayOfTheWeek, String activity) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.activity = activity;
    }

    public DaysOfTheWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public String getActivity() {
        return activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DaySchedule schedule = (DaySchedule) o;
        return dayOfTheWeek == schedule.dayOfTheWeek &&
                Objects.equals(activity, schedule.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayOfTheWeek, activity);
    }

    @Override
    public String toString() {
        return "DaySchedule{" +
                "dayOfTheWeek = " + dayOfTheWeek +
                ", activity = " + activity + '\'' +
                '}';
    }
}
