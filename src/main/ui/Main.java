package ui;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        // Create's a new user setup interface
        UserSetup setup = new UserSetup();

        // Requests user info to create new user and course load
        setup.getUserInfo();
        setup.saveUser();

    }
}
