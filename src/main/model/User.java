package model;


import java.io.*;
import java.util.Observable;
import java.util.Observer;

public class User implements Observer {
    private String username;
    private String firstName;
    private String lastName;
    private String major;
    private CourseLoad courseLoad;
    private String userString;


    public User() {
        this.courseLoad = new CourseLoad(this);
        this.firstName = "";
        this.lastName = "";
        this.major = "";

    }

    @Override
    public void update(Observable observable, Object arg) {
        Course course = (Course) arg;
        if (!(course.getName() == null)) {
            System.out.println(course.getName() + " has been added to your courseload!");
        }

    }

    public String toString() {
        userString = "Name: " + this.firstName + " " + this.lastName + "\n"
                + "Major: " + this.major + "\n"
                + "Courses: " + this.courseLoad;

        return userString;

    }

    public void setUsername(String name) {
        this.username = name;
    }

    // REQUIRES: a string
    // MODIFIES: this
    // EFFECTS: sets first name of user
    public void setFirstName(String name) {
        this.firstName = name;
    }

    // REQUIRES: a string
    // MODIFIES: this
    // EFFECTS: sets last name of user
    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getUsername() {
        return this.username;
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns first name of user
    public String getFirstName() {
        return firstName;
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns last name of user
    public String getLastName() {
        return lastName;
    }

    // REQUIRES: a string
    // MODIFIES: this
    // EFFECTS: sets the major of user
    public void setMajor(String major) {
        this.major = major;
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns major of user
    public String getMajor() {
        return major;
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns courseload of user
    public CourseLoad getCourseLoad() {
        return courseLoad;
    }


}
