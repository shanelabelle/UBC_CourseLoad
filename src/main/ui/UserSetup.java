package ui;

import exceptions.BadUserName;
import exceptions.UserFileNotFound;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserSetup {
    private User user;
    private Scanner scan;
    private PrintedResponses print;

    public UserSetup() {
        this.user = new User();
        this.scan = new Scanner(System.in);
        this.print = new PrintedResponses();

    }

    public User getUser() {
        return this.user;
    }


    // REQUIRES: none
    // MODIFIES: this
    // EFFECTS: sets up a new user or loads an existing one
    public void getUserInfo() throws IOException, ClassNotFoundException {

        print.welcomeMessage();
        boolean goodUser = false;

        while (!goodUser) {

            System.out.println("To sign in enter (s) to create a new account enter (n):");

            String loadOrNew = this.scan.nextLine();
            if (loadOrNew.toUpperCase().equals("S")) {
                System.out.println("Enter your first and last name (with a space between) to load your account:");
                String username = this.scan.nextLine();
                goodUser = this.userLogin(username);

            }
            if (loadOrNew.toUpperCase().equals("N")) {
                this.newUserSetup();
                goodUser = true;
            }

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

        this.user.getCourseLoad().toString();
    }

    public void newUserSetup() throws IOException {
        this.askForPersonalInfo();
        this.askForCourses();
        this.saveUser();
    }

    public boolean userLogin(String username) {


        try {
            loadUser(username);
            return true;
        } catch (BadUserName e) {
            System.out.println("Sorry, that username doesn't exist, please make sure to type your first"
                    + "name, followed by a space, then your last name.");
            return false;
        } catch (UserFileNotFound e) {
            System.out.println("Sorry, that username doesn't exist, please try again or create a new user.");
            return false;
        } catch (IOException e) {
            System.out.println("Sorry, that username doesn't exist, please try again or create a new user.");
            return false;

        }


    }

    public void saveUser() throws IOException {

        File userFile = new File("./data/" + this.user.getLastName() + "_" + this.user.getFirstName() + ".txt");
        FileOutputStream output = new FileOutputStream(userFile);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output));

        bw.write(this.user.getFirstName());
        bw.newLine();
        bw.write(this.user.getLastName());
        bw.newLine();
        bw.write(this.user.getMajor());
        bw.newLine();
        bw.write(this.user.getCourseLoad().toString());
        bw.close();

    }

    public void loadUser(String username) throws IOException, BadUserName, UserFileNotFound {

        ArrayList<String> inputList = fileToList(username);


        this.user = inputListToUser(inputList);
        System.out.println(this.user);
    }

    public ArrayList<String> fileToList(String username) throws IOException, BadUserName, UserFileNotFound {

        try {
            String[] split = username.split(" ");
            String filename = split[1] + "_" + split[0];

            FileInputStream input = new FileInputStream(new File("./data/"
                    + filename + ".txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(input));

            String thisLine = null;

            ArrayList<String> lines = new ArrayList<String>();

            while ((thisLine = br.readLine()) != null) {
                lines.add(thisLine);

            }

            input.close();

            return lines;

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new BadUserName();
        } catch (FileNotFoundException e) {
            throw new UserFileNotFound();
        }


    }

    public User inputListToUser(ArrayList<String> inputList) {

        User userToLoad = new User();
        userToLoad.setFirstName(inputList.get(0));
        userToLoad.setLastName(inputList.get(1));
        userToLoad.setMajor(inputList.get(2));

        String[] courses = inputList.get(3).split(", ");

        for (String course: courses) {
            userToLoad.getCourseLoad().addCourse(course);
        }

        return userToLoad;

    }


}
