package ui;


public class Main {
    public static void main(String[] args) {


        // Create's a new user setup interface
        UserSetup setup = new UserSetup();

        // Requests user info to create new user and course load
        setup.getUserInfo();
        setup.askForCourses();

    }
}
