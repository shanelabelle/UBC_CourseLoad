package model;

import java.util.ArrayList;

public class CourseLoad {
    private ArrayList<Course> courses;
    private int numberOfCourses;

    public CourseLoad() {
        this.courses = new ArrayList<>();
        this.numberOfCourses = 0;

    }
    // REQUIRES: a string
    // MODIFIES: this
    // EFFECTS: adds new course to the user's courseload
    public void addCourse(String courseName) {
        Course newCourse = new Course(courseName);

        this.courses.add(newCourse);
        this.numberOfCourses = ++this.numberOfCourses;
    }

    // REQUIRES: a string
    // MODIFIES: this
    // EFFECTS: removes new course to the user's courseload
    public void removeCourse(String courseName) {
        if (this.courses.contains(courseName)) {
            this.courses.remove(courseName);
            this.numberOfCourses = --this.numberOfCourses;
        }
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns list of courses
    public ArrayList getCourseList() {
        return this.courses;
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns number of courses
    public int getNumberOfCourses() {
        return this.numberOfCourses;
    }
}
