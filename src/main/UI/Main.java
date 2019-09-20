package UI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserSetup setup = new UserSetup();

        setup.getUserInfo();
        setup.askForCourses();

    }
}
