package ro.fasttrackit.curs13.homework.exercise1.v2;

import ro.fasttrackit.curs13.homework.exercise1.v1.DaysOfTheWeek;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScheduleForTheDay {
    private DaysOfTheWeek dayOfTheWeek;
    private List<String> activities = new ArrayList<>();

    public ScheduleForTheDay(DaysOfTheWeek dayOfTheWeek, String activity) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.activities.add(activity);
    }

    public void addActivity(String activity) {
        this.activities.add(activity);
    }

    public DaysOfTheWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public List<String> getActivities() {
        return activities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleForTheDay that = (ScheduleForTheDay) o;
        return dayOfTheWeek == that.dayOfTheWeek &&
                Objects.equals(activities, that.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayOfTheWeek, activities);
    }

    @Override
    public String toString() {
        return "ScheduleForTheDay{" +
                "dayOfTheWeek = " + dayOfTheWeek +
                ", activities = " + activities +
                '}';
    }
}
