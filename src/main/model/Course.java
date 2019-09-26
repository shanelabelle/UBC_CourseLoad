package model;

public class Course {

    private String courseName;

    public Course(String name) {
        this.courseName = name;
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns course name
    public String getCourseName() {
        return this.courseName;
    }
}
