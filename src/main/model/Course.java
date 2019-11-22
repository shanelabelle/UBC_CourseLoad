package model;

import network.FetchCourseDescription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

    public void addSegment(Segment segment) {

        if (!this.segments.contains(segment)) {
            segments.add(segment);
        }
    }

    public void removeSegment(Segment segment) {

        if (this.segments.contains(segment)) {
            this.segments.remove(segment);
        }
    }

    public void sortSegments() {
        this.segments.sort(Segment::compareTo);
        Collections.sort(this.segments, Collections.reverseOrder());
    }

    public ArrayList<Segment> getSegments() {
        return this.segments;
    }
}
