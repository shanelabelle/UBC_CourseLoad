package model;


import java.io.*;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String major;
    private CourseLoad courseLoad;
    private String userString;


    public User() {
        this.courseLoad = new CourseLoad();
        this.firstName = "";
        this.lastName = "";
        this.major = "";

    }

    public String toString() {
        userString = "Name: " + this.firstName + " " + this.lastName + "\n"
                + "Major: " + this.major + "\n"
                + "Courses: " + this.courseLoad;

        return userString;

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

    public String courseString() {

        return this.courseLoad.toString();
    }


}
