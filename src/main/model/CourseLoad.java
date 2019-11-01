package model;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseLoad {
    private int numberOfCourses;
    private String fileOutput;
    private HashMap<Block,ArrayList<Segment>> courses;

    public CourseLoad() {
        this.courses = new HashMap<>();
        this.numberOfCourses = 0;

    }

    public String toString() {
        fileOutput = "";
        int counter = 0;
        for (Block block : this.courses.keySet()) {
            if (counter == 0) {
                fileOutput = block.getName();
                counter++;
            } else {
                fileOutput = fileOutput + ", " + block.getName();
            }
        }
        return fileOutput;
    }

    // REQUIRES: a string
    // MODIFIES: this
    // EFFECTS: adds new course to the user's courseload
    public void addCourse(String courseName) {
        Block newCourse = new Course(courseName);

        this.courses.put(newCourse,new ArrayList<>());
        this.numberOfCourses = ++this.numberOfCourses;
    }

    // REQUIRES: a string
    // MODIFIES: this
    // EFFECTS: removes new course to the user's courseload
    public void removeCourse(String courseName) {

        for (Block block : this.courses.keySet()) {
            if (block.getName().equals(courseName)) {
                this.courses.remove(block);
                this.numberOfCourses = --this.numberOfCourses;
            }
        }
    }

    public void removeAllCourses() {
        this.courses = new HashMap<>();
        this.numberOfCourses = 0;
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns list of courses
    public ArrayList getCourseList() {
        ArrayList<String> courseList = new ArrayList();
        for (Block block : this.courses.keySet()) {
            courseList.add(block.getName());
        }
        return courseList;
    }

//     REQUIRES: none
//     MODIFIES: none
//     EFFECTS: returns number of courses
    public int getNumberOfCourses() {
        return this.numberOfCourses;
    }
}
