package ro.fasttrackit.curs13.homework.exercise1;

import java.util.*;

public class DailyPlanner {
    private List<DaySchedule> dailySchedules = new ArrayList<>();

    public void addActivity(DaysOfTheWeek dayOfTheWeek, String activity) {
        if (activity.isEmpty()) {
            throw new NoActivityException(activity);
        }
        this.dailySchedules.add(new DaySchedule(dayOfTheWeek, activity));
    }

    public void removeActivity(DaysOfTheWeek dayOfTheWeek, String activity) {
        if (!checkActivity(activity) || !checkDay(dayOfTheWeek)) {
            throw new NoActivityException(activity);
        }
        this.dailySchedules.remove(new DaySchedule(dayOfTheWeek, activity));
    }

    public Map<DaysOfTheWeek, List<String>> endPlanning() {
        Map<DaysOfTheWeek, List<String>> result = new HashMap<>();
        for (DaySchedule schedule : this.dailySchedules) {
            if (!result.containsKey(schedule.getDayOfTheWeek())) {
                result.put(schedule.getDayOfTheWeek(), new ArrayList<>());
            }
            result.get(schedule.getDayOfTheWeek()).add(schedule.getActivity());
        }
        return result;
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

    public List<String> getActivities(DaysOfTheWeek dayOfTheWeek) {
        return endPlanning().get(dayOfTheWeek);
    }

    private boolean checkActivity(String activity) {
        for (DaySchedule daySchedule : this.dailySchedules) {
            if (daySchedule.getActivity().equals(activity)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDay(DaysOfTheWeek dayOfTheWeek) {
        for (DaySchedule schedule : this.dailySchedules) {
            if (schedule.getDayOfTheWeek().equals(dayOfTheWeek)) {
                return true;
            }
        }
        return false;
    }

    public List<DaySchedule> getDailySchedules() {
        return dailySchedules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyPlanner planner = (DailyPlanner) o;
        return Objects.equals(dailySchedules, planner.dailySchedules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dailySchedules);
    }

    @Override
    public String toString() {
        return "DailyPlanner{" +
                "dailySchedules = " + dailySchedules +
                '}';
    }
}
