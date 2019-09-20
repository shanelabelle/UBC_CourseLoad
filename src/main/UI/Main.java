package UI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // this is the main line

        UserSetup setup = new UserSetup();

        setup.getUserInfo();
        setup.askForCourses();

    }
}
