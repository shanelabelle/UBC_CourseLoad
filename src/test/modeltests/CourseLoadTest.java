package modeltests;

import model.Course;
import model.CourseLoad;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseLoadTest {
    CourseLoad courseload;
    Course course;


    @BeforeEach
    void setUp() {
        User guy = new User();
        courseload = new CourseLoad(guy);
        course = new Course("CPSC 210");
    }

    @Test
    void addCourseTest() {
        courseload.addCourse(course);

        assertTrue(courseload.contains("CPSC 210"));
    }

    @Test
    void addCourseTestAlreadyThere() {
        courseload.addCourse(course);
        courseload.addCourse(course);
        assertTrue(courseload.contains("CPSC 210"));
        assertEquals(1,courseload.size());

    }

    @Test
    void removeCourseTestEmpty() {
        courseload.removeCourse(course);
        assertTrue(courseload.getCourseList().isEmpty());
    }

    @Test
    void removeCourseTest() {
        courseload.addCourse(course);
        courseload.removeCourse(course);

        assertTrue(courseload.getCourseList().isEmpty());
    }

    @Test
    void getCourseListTest() {
        courseload.addCourse(course);
        courseload.addCourse(new Course("PHYS 333"));
        courseload.addCourse(new Course("MATH 302"));

        ArrayList<String> coursecheck = new ArrayList();

        coursecheck.add("CPSC 210");
        coursecheck.add("PHYS 333");
        coursecheck.add("MATH 302");

        int i = 0;

        while (i < coursecheck.size()){
            assertEquals(courseload.getCourseList().get(i).toString(), coursecheck.get(i));
            i++;
        }
    }

    @Test
    void toStringTest() {
        courseload.addCourse(new Course("CPSC 210"));
        courseload.addCourse(new Course("PHYS 333"));
        courseload.addCourse(new Course("MATH 302"));

        assertEquals(courseload.toString(), "CPSC 210, PHYS 333, MATH 302");

    }

    @Test
    void getNumberOfCoursesTest() {
        assertEquals(0,courseload.getNumberOfCourses());

        courseload.addCourse(new Course("CPSC 210"));
        assertEquals(1,courseload.getNumberOfCourses());

        courseload.addCourse(new Course("PHYS 333"));
        assertEquals(2,courseload.getNumberOfCourses());

        courseload.removeAllCourses();
        assertEquals(0,courseload.getNumberOfCourses());
    }

    @Test
    void removeAllCoursesTest() {
        courseload.addCourse(new Course("CPSC 210"));
        courseload.addCourse(new Course("PHYS 333"));
        courseload.addCourse(new Course("MATH 302"));

        courseload.removeAllCourses();

        assertEquals(0,courseload.getNumberOfCourses());
        assertTrue(courseload.getCourseList().isEmpty());

    }

    @Test
    void getTestTrue() {

        courseload.addCourse(new Course("CPSC 210"));
        courseload.addCourse(new Course("PHYS 333"));
        courseload.addCourse(new Course("MATH 302"));

        Course course1 = new Course("CPSC 210");
        Course course2 = new Course("PHYS 333");
        Course course3 = new Course("MATH 302");

        assertEquals(courseload.get(0),course1);
        assertEquals(courseload.get(1),course2);
        assertEquals(courseload.get(2),course3);

    }

    @Test
    void getTestFalse() {
        try {
            courseload.get(0);
            fail();
        } catch (Exception e){

        }

    }

    @Test
    void sizeTest() {
        courseload.addCourse(new Course("CPSC 210"));

        assertEquals(1,courseload.size());

    }

    @Test
    void sizeTestEmpty() {
        assertEquals(0,courseload.size());
    }

    @Test
    void containsTestTrue() {
        courseload.addCourse(new Course("CPSC 210"));

        assertTrue(courseload.contains("CPSC 210"));
    }

    @Test
    void containsTestFalse() {
        assertFalse(courseload.contains("CPSC 210"));
    }

    @Test
    void iteratorTest() {
        courseload.addCourse(new Course("CPSC 210"));
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course("CPSC 210"));

        assertEquals(courseload.iterator().next(),courseList.get(0));

    }

}