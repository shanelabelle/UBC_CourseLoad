package ui;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserSetup implements Serializable {
    private User user;
    private Scanner scan;

    public UserSetup() {
        this.user = new User();
        this.scan = new Scanner(System.in);
    }

    public void welcomeMessage() {
        System.out.println("Hi there, welcome to CourseLoad 1.0!"
                + "\n"
                + "This is an App that lets you you manage and "
                + "track your time throughout each semester at University."
                + "\n"
                + "To get things started, I need to know a little bit about yourself...");

    }

    // REQUIRES: none
    // MODIFIES: this
    // EFFECTS: Asks the user for first name, last name, major.
    public void getUserInfo() throws IOException, ClassNotFoundException {

        this.welcomeMessage();

        System.out.println("To sign in enter (s) to create a new account enter (n):");

        String loadOrNew = this.scan.nextLine();
        if (loadOrNew.toUpperCase().equals("S")) {
            this.userLogin();
        } else {
            this.newUserSetup();

        }


    }

    public void askForPersonalInfo() {

        System.out.println("What is your first name?");
        String firstName = this.scan.nextLine();
        this.user.setFirstName(firstName);

        System.out.println("What is your last name?");
        String lastName = this.scan.nextLine();
        this.user.setLastName(lastName);

        System.out.println("What is your major?");
        String major = this.scan.nextLine();
        this.user.setMajor(major);
    }

    // REQUIRES: none
    // MODIFIES: this
    // EFFECTS: Get's user to input courses they are currently enrolled in
    public void askForCourses() {

        boolean doneAddingCourses = false;

        while (!doneAddingCourses) {
            System.out.println("To add a course, please enter a course title:");
            String course = this.scan.nextLine();
            this.user.getCourseLoad().addCourse(course);
            System.out.println("You have added " + course + ", would you like to add another course?(Y/N)");
            String addcourse = this.scan.nextLine().toUpperCase();

            if (addcourse.equals("N")) {
                doneAddingCourses = true;
            }
        }

        this.user.printCourses();
    }

    public void newUserSetup() {
        this.askForPersonalInfo();
        this.askForCourses();
    }

    public void userLogin() throws IOException, ClassNotFoundException {

        System.out.println("Enter your first and last name (with a space between) to load your account:");
        String username = this.scan.nextLine();

        loadUser(username);


    }

    public void saveUser() throws IOException {

        File userFile = new File("./data/" + this.user.getLastName() + "_" + this.user.getFirstName() + ".txt");
        FileOutputStream output = new FileOutputStream(userFile);
        ObjectOutputStream userObject = new ObjectOutputStream(output);
        userObject.writeObject(this.user);

        output.close();
        userObject.close();

    }

    public void loadUser(String username) throws IOException, ClassNotFoundException {

        String[] split = username.split(" ");
        String filename = split[1] + "_" + split[0];

        FileInputStream input = new FileInputStream(new File("./data/"
                + filename + ".txt"));
        ObjectInputStream userObject = new ObjectInputStream(input);

        this.user = (User) userObject.readObject();

        input.close();
        userObject.close();

    }


}
