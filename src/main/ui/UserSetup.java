package ui;

import model.User;

import java.util.Scanner;

public class UserSetup {
    private User user;

    public UserSetup() {
        this.user = new User();
    }

    // Asks the user for first name, last name, major.
    public void getUserInfo() {

        System.out.println("Hi there, welcome to CourseLoad 1.0!"
                + "\n"
                + "This is an App that lets you you manage and "
                + "track your time throughout each semester at University."
                + "\n"
                + "To get things started, I need to know a little bit about yourself...");

        Scanner scan = new Scanner(System.in);
        System.out.println("What is your first name?");
        String firstName = scan.nextLine();
        this.user.setFirstName(firstName);

        System.out.println("What is your last name?");
        String lastName = scan.nextLine();
        this.user.setLastName(lastName);

        System.out.println("What is your major?");
        String major = scan.nextLine();
        this.user.setMajor(major);
    }

    // Get's user to input courses they are currently enrolled in
    public void askForCourses() {

        boolean doneAddingCourses = false;
        Scanner courseScan = new Scanner(System.in);

        while (!doneAddingCourses) {
            System.out.println("To add a course, please enter a course title:");
            String course = courseScan.nextLine();
            this.user.getCourseLoad().addCourse(course);
            System.out.println("You have added " + course + ", would you like to add another course?(Y/N)");
            String addcourse = courseScan.nextLine().toUpperCase();

            if (addcourse.equals("N")) {
                doneAddingCourses = true;
            }


        }
    }
}
