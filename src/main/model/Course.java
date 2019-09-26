package model;

public class Course {

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
    public String getCourseName() {
        return this.courseName;
    }
}
