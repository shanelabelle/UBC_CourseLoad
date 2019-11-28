package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;

public class CourseLoad extends Observable implements Iterable<Course> {
    private int numberOfCourses;
    private String fileOutput;
    private ArrayList<Course> courses;
    private User user;

    public CourseLoad(User user) {
        this.courses = new ArrayList<>();
        this.numberOfCourses = 0;
        this.user = user;

    }

    public Course get(int index) {
        return this.courses.get(index);
    }

    public int size() {
        return this.courses.size();
    }

    public boolean contains(String courseName) {
        Course course = new Course(courseName);

        if (this.courses.contains(course)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        fileOutput = "";

        for (Course course: courses) {
            fileOutput = fileOutput + course.getName() + ": ";
            for (Segment segment: course) {
                if (segment.equals(course.getSegments().get(0))) {
                    fileOutput = fileOutput + segment.getType() + " " + segment.getWeight();
                } else {
                    fileOutput = fileOutput + ", " + segment.getType() + " " + segment.getWeight();
                }
            }
            fileOutput = fileOutput + "\n";

        }
//        int counter = 0;
//        while (counter < this.courses.size()) {
//            if (counter == 0) {
//                fileOutput = this.courses.get(0).getName() + ": ";
//                counter++;
//            } else {
//                fileOutput = fileOutput + ", " + this.courses.get(counter).getName();
//                counter++;
//            }
//        }
        return fileOutput;
    }

    // REQUIRES: a string
    // MODIFIES: this
    // EFFECTS: adds new course to the user's courseload
    public void addCourse(Course newCourse) {
//        Course newCourse = new Course(courseName);
        if (!courses.contains(newCourse)) {
            this.courses.add(newCourse);
            this.numberOfCourses = ++this.numberOfCourses;
        }
    }

    // REQUIRES: a string
    // MODIFIES: this
    // EFFECTS: removes new course to the user's courseload
    public void removeCourse(Course course) {
//        Course course = new Course(courseName);

        if (this.courses.contains(course)) {
            this.courses.remove(course);
            this.numberOfCourses--;
        }

    }

    public void removeAllCourses() {
        this.courses = new ArrayList<Course>();
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

    @Override
    public Iterator<Course> iterator() {
        return this.courses.iterator();
    }
}
