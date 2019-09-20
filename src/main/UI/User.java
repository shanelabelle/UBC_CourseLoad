package UI;

public class User {
    private String firstName;
    private String lastName;
    private CourseLoad courseLoad;


    public User(){
        this.courseLoad = new CourseLoad();
        this.firstName = "";
        this.lastName = "";

    }

    public setFirstName(String name){
        this.firstName = name;
    }
    public setLastName (String name){
        this.lastName = name;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
