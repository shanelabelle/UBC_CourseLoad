package ui;

import java.util.ArrayList;

public class CourseLoad {
    private ArrayList<Course> courses;
    private int numberOfCourses;

    public CourseLoad() {
        this.courses = new ArrayList<Course>();
        this.numberOfCourses = 0;

    }

    // Add's new course to the user's courseload
    public void addCourse(String courseName) {
        Course newCourse = new Course(courseName);

        this.courses.add(newCourse);
        this.numberOfCourses = ++this.numberOfCourses;
    }

    // Remove's a course from the user's courseload
    public void removeCourse(String courseName) {
        if (this.courses.contains(courseName)) {
            this.courses.remove(courseName);
            this.numberOfCourses = --this.numberOfCourses;
        }
    }

    public ArrayList getCourseList() {
        return this.courses;
    }



    public int getNumberOfCourses() {
        return this.numberOfCourses;
    }
}
