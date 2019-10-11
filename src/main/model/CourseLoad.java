package model;

import java.io.Serializable;
import java.util.ArrayList;

public class CourseLoad extends BlockList {
    private ArrayList<Course> courses;
    private int numberOfCourses;
    private String output;

    public CourseLoad() {
        this.courses = new ArrayList<Course>();
        this.numberOfCourses = 0;

    }

    public String toString() {
        output = "";
        int counter = 0;
        while (counter < this.courses.size()) {
            if (counter == 0) {
                output = this.courses.get(0).getName();
                counter++;
            } else {
                output = output + ", " + this.courses.get(counter).getName();
                counter++;
            }
        }
        return output;
    }

    // REQUIRES: a string
    // MODIFIES: this
    // EFFECTS: adds new course to the user's courseload
    public void addProject(String courseName) {
        Course newCourse = new Course(courseName);

        this.courses.add(newCourse);
        this.numberOfCourses = ++this.numberOfCourses;
    }

    // REQUIRES: a string
    // MODIFIES: this
    // EFFECTS: removes new course to the user's courseload
    public void removeProject(String courseName) {

        int x = 0;

        while (x < this.courses.size()) {
            if (this.courses.get(x).getName().equals(courseName)) {
                this.courses.remove(x);
                this.numberOfCourses = --this.numberOfCourses;
                x++;
            } else {
                x++;
            }
        }
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns list of courses
    public ArrayList getProjectList() {
        return this.courses;
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns number of courses
    public int getNumberOfCourses() {
        return this.numberOfCourses;
    }
}
