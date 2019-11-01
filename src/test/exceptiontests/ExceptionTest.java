package exceptiontests;

import exceptions.BadUserName;
import exceptions.UserFileNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import ui.UserSetup;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

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

        } catch (Exception e) {
            fail();

        }
    }

    @Test
    void testUserLoginBadUser() {
        try {
            this.testUser.loadUser("bad");
            fail();
        } catch (BadUserName e) {

        } catch (IOException e) {

        } catch (UserFileNotFound e) {

        }
    }


}
