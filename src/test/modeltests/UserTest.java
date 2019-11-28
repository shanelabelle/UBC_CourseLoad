package modeltests;

import model.CourseLoad;
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


    @Test
    void toStringTest() {
        user.setFirstName("Shane");
        user.setLastName("Labelle");
        user.setMajor("Computer Science");
        user.getCourseLoad().addCourse("CPSC 210");
        assertEquals(user.toString(),"Name: Shane Labelle\nMajor: Computer Science\nCourses: CPSC 210");

    }

    @Test
    void setUserNameTest() {
        user.setUserName("smlabell");
        assertEquals("smlabell",user.getUsername());
    }

    @Test
    void getUserNameTest() {
        user.setUserName("smlabell");
        assertEquals("smlabell",user.getUsername());
    }

    @Test
    void getCourseLoadTest() {
        user.getCourseLoad().addCourse("CPSC 210");
        user.getCourseLoad().addCourse("MATH 302");

        CourseLoad courseload = new CourseLoad(user);

        courseload.addCourse("CPSC 210");
        courseload.addCourse("MATH 302");

        assertEquals(courseload.get(0),user.getCourseLoad().get(0));
        assertEquals(courseload.get(1),user.getCourseLoad().get(1));
    }

}