package ro.fasttrackit.curs13.homework.exercise1.v2;

import ro.fasttrackit.curs13.homework.exercise1.v1.DaysOfTheWeek;
import ro.fasttrackit.curs13.homework.exercise1.exceptions.NoActivitiesForDayException;
import ro.fasttrackit.curs13.homework.exercise1.exceptions.NoActivityException;

import java.util.*;

public class SchedulePlanner {
    private List<ScheduleForTheDay> schedules = new ArrayList<>();

    private Set<DaysOfTheWeek> getScheduleDays() {
        Set<DaysOfTheWeek> result = new HashSet<>();
        for (ScheduleForTheDay schedule : this.schedules) {
            result.add(schedule.getDayOfTheWeek());
        }
        return result;
    }

    public Map<DaysOfTheWeek, List<String>> endPlanning() {
        Map<DaysOfTheWeek, List<String>> result = new HashMap<>();
        for (ScheduleForTheDay schedule : this.schedules) {
            result.put(schedule.getDayOfTheWeek(), schedule.getActivities());
        }
        return result;
    }

    public List<String> getActivities(DaysOfTheWeek dayOfTheWeek) {
        return endPlanning().get(dayOfTheWeek);
    }

    public void checkDailySchedules() throws NoActivitiesForDayException {
        Set<DaysOfTheWeek> scheduledDays = endPlanning().keySet();
        DaysOfTheWeek[] days = DaysOfTheWeek.values();
        for (DaysOfTheWeek day : days) {
            if (!scheduledDays.contains(day)) {
                throw new NoActivitiesForDayException(day);
            }
        }
    }

    public void addActivityForTheDay(DaysOfTheWeek dayOfTheWeek, String activity) {
        if (activity == null || activity.isEmpty()) {
            throw new NoActivityException(activity);
        }
        ScheduleForTheDay schedule = new ScheduleForTheDay(dayOfTheWeek, activity);
        if (this.schedules.isEmpty() || !getScheduleDays().contains(dayOfTheWeek)) {
            schedules.add(schedule);
        } else {
            for (ScheduleForTheDay daySchedule : this.schedules) {
                if (schedule.getDayOfTheWeek().equals(daySchedule.getDayOfTheWeek())) {
                    daySchedule.getActivities().add(activity);
                }
            }
        }
    }

    public List<ScheduleForTheDay> getSchedules() {
        return schedules;
    }

    public void removeActivity(DaysOfTheWeek dayOfTheWeek, String activity) {
        if (!checkActivity(dayOfTheWeek, activity) || !checkDay(dayOfTheWeek)) {
            throw new NoActivityException(activity);
        }
        for (ScheduleForTheDay schedule : this.schedules) {
            if (schedule.getDayOfTheWeek().equals(dayOfTheWeek)) {
                schedule.getActivities().remove(activity);
            }
        }
    }

    private boolean checkActivity(DaysOfTheWeek dayOfTheWeek, String activity) {
        for (ScheduleForTheDay schedule : this.schedules) {
            if (schedule.getActivities().contains(activity) && schedule.getDayOfTheWeek().equals(dayOfTheWeek)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDay(DaysOfTheWeek dayOfTheWeek) {
        for (ScheduleForTheDay schedule : this.schedules) {
            if (schedule.getDayOfTheWeek().equals(dayOfTheWeek)) {
                return true;
            }
        }
        return false;
    }
}
