package ro.fasttrackit.curs13.homework.exercise1.exceptions;

public class NoActivityException extends RuntimeException {
    private final String activity;

    public NoActivityException(String activity) {
        super("Invalid activity");
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }
}
