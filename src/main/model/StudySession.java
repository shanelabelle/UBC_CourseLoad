package model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudySession {
    private double duration;
    private LocalDateTime startTime;

    public StudySession(double duration) {
        this.duration = duration;
        this.startTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY/MM/DD hh:mm:ss");
    }
}
