package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Course extends Block {

    private String courseName;
    private ArrayList<Segment> segments;

    public Course(String name) {

        this.courseName = name;
        this.segments = new ArrayList<>();

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
