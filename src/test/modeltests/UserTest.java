package modeltests;

import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void setFirstName() {
        user.setFirstName("Shane");
        assertEquals("Shane", user.getFirstName());
    }

    @Test
    void setLastName() {
        user.setLastName("Labelle");
        assertEquals("Labelle",user.getLastName());
    }

    @Test
    void getFirstName() {
        user.setFirstName("Shane");
        assertEquals("Shane", user.getFirstName());
    }

    @Test
    void getLastName() {
        user.setLastName("Labelle");
        assertEquals("Labelle",user.getLastName());
    }

    @Test
    void setMajor() {
        user.setMajor("Computer Science");
        assertEquals("Computer Science",user.getMajor());
    }

    @Test
    void getMajor() {
        user.setMajor("Computer Science");
        assertEquals("Computer Science",user.getMajor());
    }

    //@Test
    //void getCourseLoad() {
    //}
}