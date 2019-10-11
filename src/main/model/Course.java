package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Course extends Block {

    private String courseName;
    private ArrayList<Segment> segments;

    public Course(String name) {
        this.courseName = name;
        this.segments = new ArrayList<Segment>();
    }

    public String toString() {
        return this.courseName;
    }

    public void addSegment(String type, int weight) {
        Segment newSegment = new Segment(type, weight);

        this.segments.add(newSegment);
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns course name
    public String getName() {
        return this.courseName;
    }
}
