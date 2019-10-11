package model;

import java.io.Serializable;

public class Course extends Block {

    private String courseName;

    public Course(String name) {
        this.courseName = name;
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
