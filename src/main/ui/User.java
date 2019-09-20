package ui;

public class User {
    private String firstName;
    private String lastName;
    private String major;
    private CourseLoad courseLoad;


    public User() {
        this.courseLoad = new CourseLoad();
        this.firstName = "";
        this.lastName = "";

    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public CourseLoad getCourseLoad() {
        return courseLoad;
    }
}
