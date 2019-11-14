package model;

import network.FetchCourseDescription;

import java.util.ArrayList;

public class Course extends Block {

    private String courseName;
    private ArrayList<Segment> segments;
    private String courseDescription;

    public Course(String name) {

        this.courseName = name;
        this.segments = new ArrayList<>();
        setCourseDescription();

    }

    public String getCourseDescription() {
        return this.courseDescription;
    }

    public void setCourseDescription() {
        FetchCourseDescription fetcher = new FetchCourseDescription();
        try {
            this.courseDescription = fetcher.getCourseTitle(this.courseName);
        } catch (Exception e) {
            this.courseDescription = null;
        }
    }

    public String toString() {
        return this.courseName;
    }


    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns course name
    public String getName() {
        return this.courseName;
    }
}
