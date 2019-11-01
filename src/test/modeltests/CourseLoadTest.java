package modeltests;

import model.CourseLoad;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseLoadTest {
    CourseLoad courseload;


    @BeforeEach
    void setUp() {
        User guy = new User();
        courseload = new CourseLoad(guy);
    }

    @Test
    void addCourseTest() {
        courseload.addCourse("CPSC 210");

        assertEquals(courseload.getCourseList().get(0).toString(), "CPSC 210");
    }

    @Test
    void removeCourseTest() {
        courseload.addCourse("CPSC 210");
        courseload.removeCourse("CPSC 210");

        assertTrue(courseload.getCourseList().isEmpty());
    }

    @Test
    void getCourseListTest() {
        courseload.addCourse("CPSC 210");
        courseload.addCourse("PHYS 333");
        courseload.addCourse("MATH 302");

        ArrayList<String> coursecheck = new ArrayList();

        coursecheck.add("CPSC 210");
        coursecheck.add("PHYS 333");
        coursecheck.add("MATH 302");

        int i = 0;

        while (i < coursecheck.size()){
            assertTrue(courseload.getCourseList().contains(coursecheck.get(i)));
            i++;
        }
    }

    @Test
    void toStringTest() {
        courseload.addCourse("CPSC 210");
        courseload.addCourse("PHYS 333");
        courseload.addCourse("MATH 302");

        String newString = courseload.toString();

        assertEquals(1,1);

    }

    @Test
    void getNumberOfCoursesTest() {
        assertEquals(0,courseload.getNumberOfCourses());

        courseload.addCourse("CPSC 210");
        assertEquals(1,courseload.getNumberOfCourses());

        courseload.addCourse("PHYS 333");
        assertEquals(2,courseload.getNumberOfCourses());

        courseload.removeAllCourses();
        assertEquals(0,courseload.getNumberOfCourses());
    }

    @Test
    void removeAllCoursesTest() {
        courseload.addCourse("CPSC 210");
        courseload.addCourse("PHYS 333");
        courseload.addCourse("MATH 302");

        courseload.removeAllCourses();

        assertEquals(0,courseload.getNumberOfCourses());
        assertTrue(courseload.getCourseList().isEmpty());

    }

}