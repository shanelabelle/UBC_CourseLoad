package exceptiontests;

import exceptions.BadUserName;
import exceptions.UserFileNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.User;
import model.CourseLoad;
import model.Course;
import ui.UserSetup;

import java.io.IOException;

public class ExceptionTest {
    UserSetup testUser;

    @BeforeEach
    void setUp() {
        this.testUser = new UserSetup();
    }

    @Test
    void testUserLoginGoodUser() {

        try{
            this.testUser.loadUser("Shane Labelle");
            System.out.println("Pass");
        } catch (Exception e) {
            System.out.println("Fail");

        }
    }

    @Test
    void testUserLoginBadUser() {
        try {
            this.testUser.loadUser("bad");
            System.out.println("Fail");
        } catch (BadUserName e) {
            System.out.println("Pass");

        } catch (IOException e) {
            System.out.println("Pass");
        } catch (UserFileNotFound e) {
            System.out.println("Pass");
        }
    }


}
