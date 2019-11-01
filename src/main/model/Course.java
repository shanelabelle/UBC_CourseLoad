package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Course extends Block {

    private String courseName;

    public Course(String name) {

        this.courseName = name;

    }

    public String toString() {
        return this.courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        return courseName.equals(course.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName);
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns course name
    public String getName() {
        return this.courseName;
    }
}
