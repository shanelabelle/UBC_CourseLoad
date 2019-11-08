package model;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseLoad {
    private int numberOfCourses;
    private String fileOutput;
    private ArrayList<Block> courses;
    private User user;

    public CourseLoad(User user) {
        this.courses = new ArrayList<>();
        this.numberOfCourses = 0;
        this.user = user;

    }

    public String toString() {
        fileOutput = "";
        int counter = 0;
        while (counter < this.courses.size()) {
            if (counter == 0) {
                fileOutput = this.courses.get(0).getName();
                counter++;
            } else {
                fileOutput = fileOutput + ", " + this.courses.get(counter).getName();
                counter++;
            }
        }
        return fileOutput;
    }

    // REQUIRES: a string
    // MODIFIES: this
    // EFFECTS: adds new course to the user's courseload
    public void addCourse(String courseName) {
        Block newCourse = new Course(courseName);

        this.courses.add(newCourse);
        this.numberOfCourses = ++this.numberOfCourses;
    }

    // REQUIRES: a string
    // MODIFIES: this
    // EFFECTS: removes new course to the user's courseload
    public void removeCourse(String courseName) {

        int counter = 0;

        while (counter < this.courses.size()) {
            if (this.courses.get(counter).getName().equals(courseName)) {
                this.courses.remove(counter);
                this.numberOfCourses--;
                counter++;
            } else {
                counter++;
            }
        }

    }

    public void removeAllCourses() {
        this.courses = new ArrayList<Block>();
        this.numberOfCourses = 0;
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns list of courses
    public ArrayList getCourseList() {

        return this.courses;
    }

//     REQUIRES: none
//     MODIFIES: none
//     EFFECTS: returns number of courses
    public int getNumberOfCourses() {
        return this.numberOfCourses;
    }
}
